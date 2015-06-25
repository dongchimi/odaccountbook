package org.dongchimi.odong.accountbook.web.resource;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.dto.CategoryDto;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.dongchimi.odong.accountbook.web.util.ODException;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.dongchimi.odong.accountbook.web.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis/category")
public class ODCategoryResource {

    // private static final Logger logger =
    // LoggerFactory.getLogger(ODCategoryResource.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 분류 등록
     * 
     * @param session
     * @param howType
     * @param categoryType
     * @param name
     * @param memo
     * @param parentCategoryId
     * @return
     */
    @RequestMapping(value = "/setAccountBookCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setAccountBookCategory(HttpSession session, @RequestParam HowType howType,
            @RequestParam CategoryType categoryType, @RequestParam String name,
            @RequestParam String memo, @RequestParam(required = false) Long parentCategoryOid) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        if (currentAccountBookOid == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("로그인하세요."));
        }

        CategoryDto registeredCategory = categoryService
                .getCategoryByHowTypeAndCategoryTypeAndName(currentAccountBookOid, howType,
                        categoryType, name);
        if (registeredCategory != null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("이미 등록된 분류가 있습니다."));
        }

        // 상위분류ID가 입력된 경우
        if (parentCategoryOid != null) {
            CategoryDto parentCategory = categoryService.getCategory(parentCategoryOid);
            if (parentCategory == null) {
                return ODRequestResultBuilder.getFailRequestResult(new ODException("상위 분류가 없습니다."));
            }

            parentCategoryOid = parentCategory.getOid();
        }

        // 상위분류ID가 없는 ITEM인 경우
        if (parentCategoryOid == null && CategoryType.ITEM.equals(categoryType)) {
            Category noGroupCategory = categoryService.registerCategory(Category
                    .createDefaultGroup(howType, currentAccountBookOid));
            parentCategoryOid = noGroupCategory.getOid();
        }

        categoryService.registerCategory(new Category(howType, categoryType, name, memo,
                currentAccountBookOid, parentCategoryOid));

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 분류 수정
     * 
     * @param session
     * @param name
     * @param memo
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/updateAccountBookCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult updateAccountBookCategory(HttpSession session, @RequestParam String name,
            @RequestParam String memo, @RequestParam String categoryId) {

        CategoryDto category = categoryService.getCategory(Long.parseLong(categoryId));

        category.setName(name);
        category.setMemo(memo);

        categoryService.registerCategory(category.toCategory());

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 분류 순서 및 대소분류 수정
     * 
     * @param session
     * @param categories
     * @return
     */
    @RequestMapping(value = "/setAccountBookCategoryOrders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setAccountBookCategoryOrders(HttpSession session,
            @RequestBody List<Category> categories) {

        categoryService.modifyCategoriesOrder(categories);

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 분류 조회
     * 
     * @return
     */
    @RequestMapping(value = "/getAccountBookCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getAccountBookCategories(HttpSession session, HowType howType) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        if (currentAccountBookOid == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("로그인하세요."));
        }

        return ODRequestResultBuilder.getSuccessRequestResult(categoryService
                .findCategoriesByHowType(currentAccountBookOid, howType));
    }

    /**
     * 분류 삭제
     * 
     * @param session
     * @param oid
     * @return
     */
    @RequestMapping(value = "/deleteAccountBookCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult deleteAccoutBookCategory(HttpSession session, long oid) {

        List<CategoryDto> subCategories = categoryService.findCategoriesByParentCategoryOid(oid);

        // 삭제할 대상이 하위분류를 가진 그룹인 경우, 하위분류를 임시분류로 등록 후 삭제
        if (!CollectionUtils.isEmpty(subCategories)) {
            CategoryDto firstSubCategory = subCategories.get(0);
            
            Long parentCategoryOid = null;
            CategoryDto noGroupCategory = categoryService
                    .getCategoryByHowTypeAndCategoryTypeAndName(
                            firstSubCategory.getAccountBookOid(), firstSubCategory.getHowType(),
                            CategoryType.GROUP, "그룹없음");

            if (noGroupCategory != null) {
                parentCategoryOid = noGroupCategory.getOid();
            } else {
                Category registeredCategory = categoryService.registerCategory(Category
                        .createDefaultGroup(firstSubCategory.getHowType(),
                                firstSubCategory.getAccountBookOid()));
                parentCategoryOid = registeredCategory.getOid();
            }

            for (CategoryDto subCategory : subCategories) {
                subCategory.setParentCategoryOid(parentCategoryOid);
                categoryService.registerCategory(subCategory.toCategory());
            }
        }

        categoryService.removeCategory(oid);

        return ODRequestResultBuilder.getSuccessRequestResult();
    }
}
