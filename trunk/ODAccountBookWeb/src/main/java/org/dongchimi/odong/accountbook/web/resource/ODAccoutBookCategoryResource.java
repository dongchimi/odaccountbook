package org.dongchimi.odong.accountbook.web.resource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.ODAccountBookCategory;
import org.dongchimi.odong.accountbook.service.ODAccountBookCategoryService;
import org.dongchimi.odong.accountbook.web.util.ODException;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
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
public class ODAccoutBookCategoryResource {

    // private static final Logger logger =
    // LoggerFactory.getLogger(ODAccoutBookCategoryResource.class);

    @Autowired
    private ODAccountBookCategoryService categoryService;

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
    ODRequestResult setAccountBookCategory(HttpSession session, @RequestParam String howType,
            @RequestParam String categoryType, @RequestParam String name,
            @RequestParam String memo, @RequestParam String parentCategoryId) {

        ODAccountBookCategory registeredCategory = categoryService
                .getCategoryByNameAndCategoryType(HowType.toHowType(howType),
                        CategoryType.toCategoryType(categoryType), name);

        if (registeredCategory != null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("이미 등록된 분류가 있습니다."));
        }

        ODAccountBookCategory parentCategory = null;
        ODAccountBookCategory category = new ODAccountBookCategory(howType, categoryType, name,
                memo);

        if (!parentCategoryId.isEmpty()) {
            parentCategory = categoryService.getCategory(Long.parseLong(parentCategoryId));

            category.setParentCategory(parentCategory);

            parentCategory.addSubCategories(category);
        } else {
            if (CategoryType.ITEM.toString().equals(categoryType)) {
                parentCategory = new ODAccountBookCategory(howType, CategoryType.GROUP.toString(),
                        "그룹없음", "");

                category.setParentCategory(parentCategory);

                parentCategory.addSubCategories(category);
            } else {
                parentCategory = category;
            }
        }

        categoryService.registerCategory(parentCategory);

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    @RequestMapping(value = "/updateAccountBookCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult updateAccountBookCategory(HttpSession session, @RequestParam String name,
            @RequestParam String memo, @RequestParam String categoryId) {

        ODAccountBookCategory category = categoryService.getCategory(Long.parseLong(categoryId));

        category.setName(name);
        category.setMemo(memo);

        categoryService.registerCategory(category);

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
            @RequestBody List<ODAccountBookCategory> categories) {

        categoryService.modifyCategoriesOrder(categories);

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 분류 조회
     * 
     * @return
     */
    @RequestMapping(value = "/getAccountBookCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getAccountBookCategories(HttpSession session, @RequestParam String howType) {

        List<ODAccountBookCategory> categories = null;
        if (howType.isEmpty()) {
            categories = categoryService.findCategories();
        } else {
            categories = categoryService.findCategoriesByHowType(HowType.toHowType(howType));
        }

        for (ODAccountBookCategory category : categories) {
            Collections.sort(category.getSubCategories(), new Comparator<ODAccountBookCategory>() {
                @Override
                public int compare(ODAccountBookCategory o1, ODAccountBookCategory o2) {
                    if (o1.getSortNumber() > o2.getSortNumber()) {
                        return 1;
                    } else if (o1.getSortNumber() < o2.getSortNumber()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        }

        return ODRequestResultBuilder.getSuccessRequestResult(categories);
    }

    /**
     * 분류 삭제
     * 
     * @param session
     * @param oId
     * @return
     */
    @RequestMapping(value = "/deleteAccountBookCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult deleteAccoutBookCategory(HttpSession session, long oId) {

        ODAccountBookCategory deleteTargetCategory = categoryService.getCategory(oId);

        if (deleteTargetCategory.getParentCategory() != null) {
            ODAccountBookCategory parentCategory = categoryService.getCategory(deleteTargetCategory
                    .getParentCategory().getoId());
            parentCategory.getSubCategories().remove(deleteTargetCategory);

            categoryService.modifyCategory(parentCategory);
        } else {
            ODAccountBookCategory noGroupCategory = categoryService
                    .getCategoryByNameAndCategoryType(deleteTargetCategory.getHowType(),
                            deleteTargetCategory.getCategoryType(), "그룹없음");
            if (noGroupCategory == null) {
                noGroupCategory = new ODAccountBookCategory(deleteTargetCategory.getHowType()
                        .toString(), CategoryType.GROUP.toString(), "그룹없음", "");
            }

            List<ODAccountBookCategory> subCategories = deleteTargetCategory.getSubCategories();
            for (ODAccountBookCategory subCategory : subCategories) {
                subCategory.setParentCategory(noGroupCategory);
                noGroupCategory.addSubCategories(subCategory);
            }

            categoryService.removeSubCategories(deleteTargetCategory);
            categoryService.modifyCategory(noGroupCategory);
        }

        categoryService.removeCategory(oId);

        return ODRequestResultBuilder.getSuccessRequestResult();
    }
}
