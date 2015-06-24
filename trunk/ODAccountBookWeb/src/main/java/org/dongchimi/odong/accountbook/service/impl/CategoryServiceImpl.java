package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.domain.CategoryRepository;
import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category registerCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(long oid) {
        return categoryRepository.findOne(oid);
    }

    @Override
    public Category getCategoryByAccountBookOidAndHowTypeAndCategoryTypeAndName(long accountBookOid, HowType howType, CategoryType categoryType, String name) {
        return categoryRepository.findByAccountBookOidAndHowTypeAndCategoryTypeAndName(accountBookOid, howType, categoryType, name);
    }

    @Override
    public List<Category> findCategories(long accountBookOid) {
        return categoryRepository.findByAccountBookOidAndCategoryTypeOrderBySortNumberAsc(accountBookOid, CategoryType.GROUP);
    }

    @Override
    public List<Category> findGroupCategoriesByAccountBookOidAndHowType(long accountBookOid, HowType howType) {
        return categoryRepository.findByAccountBookOidAndHowTypeAndCategoryTypeOrderBySortNumberAsc(accountBookOid, howType,
                CategoryType.GROUP);
    }

    @Override
    public void removeCategory(long oid) {
        categoryRepository.delete(oid);
    }

    @Override
    public void modifyCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void modifyCategoriesOrder(List<Category> categories) {
        if (CollectionUtils.isEmpty(categories)) return;
        
        for (Category category : categories) {
            Category modifyTargetCategory = this.getCategory(category.getOid());
            
            modifyTargetCategory.setSortNumber(category.getSortNumber());
            modifyTargetCategory.setParentCategoryOid(category.getParentCategoryOid());
            
            categoryRepository.save(modifyTargetCategory);
        }
    }
    
    @Override
    public void removeSubCategories(Category category) {
        if (CollectionUtils.isEmpty(category.getSubCategories())) return;
        
//        for (Category subCategory : category.getSubCategories()) {
//            subCategory.setParentCategory(null);
//        }
        
        category.setSubCategories(null);
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoriesByParentCategoryOid(long parentCategoryOid) {
        return categoryRepository.findByParentCategoryOidOrderBySortNumberAsc(parentCategoryOid);
    }

}
