package org.dongchimi.odong.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.domain.CategoryRepository;
import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.dto.CategoryDto;
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
    public void registerDefaultCategory(Long accountBookOid) {
        categoryRepository.save(Category.createDefaultGroup(HowType.IN, accountBookOid));
        categoryRepository.save(Category.createDefaultGroup(HowType.OUT, accountBookOid));
        categoryRepository.save(Category.createDefaultGroup(HowType.SAVING, accountBookOid));
    }

    @Override
    public CategoryDto getCategory(long oid) {
        return CategoryDto.toCategoryDto(categoryRepository.findOne(oid));
    }

    @Override
    public CategoryDto getCategoryByHowTypeAndCategoryTypeAndName(long accountBookOid,
            HowType howType, CategoryType categoryType, String name) {
        return CategoryDto.toCategoryDto(categoryRepository
                .findByAccountBookOidAndHowTypeAndCategoryTypeAndName(accountBookOid, howType,
                        categoryType, name));
    }

    @Override
    public List<CategoryDto> findCategoryDtos(long accountBookOid) {
        List<Category> categories = categoryRepository
                .findByAccountBookOidAndCategoryTypeOrderBySortNumberAsc(accountBookOid,
                        CategoryType.GROUP);

        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();

        for (Category category : categories) {
            CategoryDto dto = CategoryDto.toCategoryDto(category);

            dto.setSubCategories(this.findCategoriesByParentCategoryOid(category.getOid()));

            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    @Override
    public List<CategoryDto> findCategoriesByHowType(long accountBookOid, HowType howType) {
        List<Category> categories = categoryRepository
                .findByAccountBookOidAndHowTypeAndCategoryTypeOrderBySortNumberAsc(accountBookOid,
                        howType, CategoryType.GROUP);

        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();

        for (Category category : categories) {
            CategoryDto dto = CategoryDto.toCategoryDto(category);

            dto.setSubCategories(this.findCategoriesByParentCategoryOid(category.getOid()));

            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    @Override
    public void removeCategory(long oid) {
        categoryRepository.delete(oid);
    }

    @Override
    public void modifyCategoriesOrder(List<Category> categories) {
        if (CollectionUtils.isEmpty(categories))
            return;

        for (Category category : categories) {
            CategoryDto modifyTargetCategory = this.getCategory(category.getOid());

            modifyTargetCategory.setSortNumber(category.getSortNumber());
            modifyTargetCategory.setParentCategoryOid(category.getParentCategoryOid());

            categoryRepository.save(modifyTargetCategory.toCategory());
        }
    }

    @Override
    public List<CategoryDto> findCategoriesByParentCategoryOid(long parentCategoryOid) {
        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();

        for (Category category : categoryRepository
                .findByParentCategoryOidOrderBySortNumberAsc(parentCategoryOid)) {
            categoryDtos.add(CategoryDto.toCategoryDto(category));
        }
        return categoryDtos;
    }

}
