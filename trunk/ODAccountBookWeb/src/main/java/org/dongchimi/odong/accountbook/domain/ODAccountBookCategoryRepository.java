package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ODAccountBookCategoryRepository extends JpaRepository<ODAccountBookCategory, Long> {

	public List<ODAccountBookCategory> findByHowTypeAndCategoryTypeOrderBySortNumberAsc(HowType howType, CategoryType categoryType);
	
	public List<ODAccountBookCategory> findByCategoryTypeOrderBySortNumberAsc(CategoryType categoryType);

    public ODAccountBookCategory findByHowTypeAndCategoryTypeAndName(HowType howType, CategoryType categoryType, String name);
}
