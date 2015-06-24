package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.Category;
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
	 * 분류를 조회한다.
	 * 
	 * @param oId
	 * @return
	 */
	public Category getCategory(long oid);
	
	/**
	 * 분류명으로 분류를 조회한다.
	 * 
	 * @param howType
	 * @param name
	 * @return
	 */
	public Category getCategoryByAccountBookOidAndHowTypeAndCategoryTypeAndName(long accountBookOid, HowType howType, CategoryType categoryType, String name);
	
	/**
	 * 모든 분류를 조회한다.
	 * 
	 * @return
	 */
	public List<Category> findCategories(long accountBookOid);
	
	/**
	 * 유형에 따른 분류를 조회한다.
	 * 
	 * @param howType
	 * @return
	 */
	public List<Category> findGroupCategoriesByAccountBookOidAndHowType(long accountBookOid, HowType howType);
	
	/**
	 * 상위분류ID로 하위분류를 조회한다.
	 * 
	 * @param parentCategoryOid
	 * @return
	 */
	public List<Category> findCategoriesByParentCategoryOid(long parentCategoryOid);
	
	/**
	 * 분류를 수정한다.
	 * 
	 * @param category
	 */
	public void modifyCategory(Category category);
	
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
	
	/**
	 * 하위 분류를 삭제한다.
	 * 
	 * @param category
	 */
	public void removeSubCategories(Category category);
}
