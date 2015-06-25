package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.dto.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    /**
     * 분류를 등록한다.
     * 
     * @param category
     */
    public Category registerCategory(Category category);

    /**
     * 기본분류를 등록한다.
     * 
     * @param accountBookOid
     */
    public void registerDefaultCategory(Long accountBookOid);

    /**
     * 분류를 조회한다.
     * 
     * @param oId
     * @return
     */
    public CategoryDto getCategory(long oid);

    /**
     * 분류유형, 입출금유형, 분류명으로 분류를 조회한다.
     * 
     * @param howType
     * @param name
     * @return
     */
    public CategoryDto getCategoryByHowTypeAndCategoryTypeAndName(
            long accountBookOid, HowType howType, CategoryType categoryType, String name);

    /**
     * 모든 분류를 조회한다.
     * 
     * @return
     */
    public List<CategoryDto> findCategoryDtos(long accountBookOid);

    /**
     * 유형에 따른 분류를 조회한다.
     * 
     * @param howType
     * @return
     */
    public List<CategoryDto> findCategoriesByHowType(long accountBookOid, HowType howType);

    /**
     * 상위분류ID로 하위분류를 조회한다.
     * 
     * @param parentCategoryOid
     * @return
     */
    public List<CategoryDto> findCategoriesByParentCategoryOid(long parentCategoryOid);

    /**
     * 분류순서를 수정한다.
     * 
     * @param categories
     */
    public void modifyCategoriesOrder(List<Category> categories);

    /**
     * 분류를 삭제한다.
     * 
     * @param oId
     */
    public void removeCategory(long oid);

}
