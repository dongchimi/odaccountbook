package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public List<Category> findByHowTypeAndCategoryTypeOrderBySortNumberAsc(HowType howType, CategoryType categoryType);
	
	public List<Category> findByCategoryTypeOrderBySortNumberAsc(CategoryType categoryType);

    public Category findByHowTypeAndCategoryTypeAndName(HowType howType, CategoryType categoryType, String name);
}
