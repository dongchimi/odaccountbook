package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.ODAccountBookCategory;
import org.dongchimi.odong.accountbook.domain.ODAccountBookCategoryRepository;
import org.dongchimi.odong.accountbook.service.ODAccountBookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class ODAccountBookCategoryServiceImpl implements ODAccountBookCategoryService {

    @Autowired
    private ODAccountBookCategoryRepository categoryRepository;

    @Override
    public void registerCategory(ODAccountBookCategory category) {
        categoryRepository.save(category);
    }

    @Override
    public ODAccountBookCategory getCategory(long oId) {
        return categoryRepository.findOne(oId);
    }

    @Override
    public ODAccountBookCategory getCategoryByNameAndCategoryType(HowType howType, CategoryType categoryType, String name) {
        return categoryRepository.findByHowTypeAndCategoryTypeAndName(howType, categoryType, name);
    }

    @Override
    public List<ODAccountBookCategory> findCategories() {
        return categoryRepository.findByCategoryTypeOrderBySortNumberAsc(CategoryType.GROUP);
    }

    @Override
    public List<ODAccountBookCategory> findCategoriesByHowType(HowType howType) {
        return categoryRepository.findByHowTypeAndCategoryTypeOrderBySortNumberAsc(howType,
                CategoryType.GROUP);
    }

    @Override
    public void removeCategory(long oId) {
        categoryRepository.delete(oId);
    }

    @Override
    public void modifyCategory(ODAccountBookCategory category) {
        categoryRepository.save(category);
    }

    @Override
    public void modifyCategoriesOrder(List<ODAccountBookCategory> categories) {
        List<ODAccountBookCategory> beforeCategories = this.findCategoriesByHowType(categories.get(
                0).getHowType());
        for (ODAccountBookCategory beforeCategory : beforeCategories) {
            this.removeSubCategories(beforeCategory);
        }
        
        categoryRepository.save(categories);
    }
    
    @Override
    public void removeSubCategories(ODAccountBookCategory category) {
        if (CollectionUtils.isEmpty(category.getSubCategories())) return;
        
        for (ODAccountBookCategory subCategory : category.getSubCategories()) {
            subCategory.setParentCategory(null);
        }
        
        category.setSubCategories(null);
        categoryRepository.save(category);
    }

}
