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
	public void registerCategory(Category category);
	
	/**
	 * 분류를 조회한다.
	 * 
	 * @param oId
	 * @return
	 */
	public Category getCategory(long oId);
	
	/**
	 * 분류명으로 분류를 조회한다.
	 * 
	 * @param howType
	 * @param name
	 * @return
	 */
	public Category getCategoryByNameAndCategoryType(HowType howType, CategoryType categoryType, String name);
	
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
	public List<Category> findCategoriesByHowType(long accountBookOid, HowType howType);
	
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
	public void modifyCategoriesOrder(long accountBookOid, List<Category> categories);
	
	/**
	 * 분류를 삭제한다.
	 * 
	 * @param oId
	 */
	public void removeCategory(long oId);
	
	/**
	 * 하위 분류를 삭제한다.
	 * 
	 * @param category
	 */
	public void removeSubCategories(Category category);
}
