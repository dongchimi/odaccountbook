package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.domain.CategoryRepository;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void registerCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategory(long oId) {
        return categoryRepository.findOne(oId);
    }

    @Override
    public Category getCategoryByNameAndCategoryType(HowType howType, CategoryType categoryType, String name) {
        return categoryRepository.findByHowTypeAndCategoryTypeAndName(howType, categoryType, name);
    }

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findByCategoryTypeOrderBySortNumberAsc(CategoryType.GROUP);
    }

    @Override
    public List<Category> findCategoriesByHowType(HowType howType) {
        return categoryRepository.findByHowTypeAndCategoryTypeOrderBySortNumberAsc(howType,
                CategoryType.GROUP);
    }

    @Override
    public void removeCategory(long oId) {
        categoryRepository.delete(oId);
    }

    @Override
    public void modifyCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void modifyCategoriesOrder(List<Category> categories) {
        List<Category> beforeCategories = this.findCategoriesByHowType(categories.get(
                0).getHowType());
        for (Category beforeCategory : beforeCategories) {
            this.removeSubCategories(beforeCategory);
        }
        
        categoryRepository.save(categories);
    }
    
    @Override
    public void removeSubCategories(Category category) {
        if (CollectionUtils.isEmpty(category.getSubCategories())) return;
        
        for (Category subCategory : category.getSubCategories()) {
            subCategory.setParentCategory(null);
        }
        
        category.setSubCategories(null);
        categoryRepository.save(category);
    }

}
