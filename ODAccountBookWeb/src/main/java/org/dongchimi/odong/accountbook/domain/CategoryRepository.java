package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public List<Category> findByAccountBookOidAndHowTypeAndCategoryTypeOrderBySortNumberAsc(long accountBookOid, HowType howType, CategoryType categoryType);
	
	public List<Category> findByAccountBookOidAndCategoryTypeOrderBySortNumberAsc(long accountBookOid, CategoryType categoryType);

	public List<Category> findByParentCategoryOidOrderBySortNumberAsc(long parentCategoryOid);
	
    public Category findByAccountBookOidAndHowTypeAndCategoryTypeAndName(long accountBookOid, HowType howType, CategoryType categoryType, String name);

}
