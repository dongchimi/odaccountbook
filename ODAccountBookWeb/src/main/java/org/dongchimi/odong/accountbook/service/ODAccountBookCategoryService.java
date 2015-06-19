package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.ODAccountBookCategory;
import org.springframework.stereotype.Service;

@Service
public interface ODAccountBookCategoryService {

	/**
	 * 분류를 등록한다.
	 * 
	 * @param category
	 */
	public void registerCategory(ODAccountBookCategory category);
	
	/**
	 * 분류를 조회한다.
	 * 
	 * @param oId
	 * @return
	 */
	public ODAccountBookCategory getCategory(long oId);
	
	/**
	 * 분류명으로 분류를 조회한다.
	 * 
	 * @param howType
	 * @param name
	 * @return
	 */
	public ODAccountBookCategory getCategoryByNameAndCategoryType(HowType howType, CategoryType categoryType, String name);
	
	/**
	 * 모든 분류를 조회한다.
	 * 
	 * @return
	 */
	public List<ODAccountBookCategory> findCategories();
	
	/**
	 * 유형에 따른 분류를 조회한다.
	 * 
	 * @param howType
	 * @return
	 */
	public List<ODAccountBookCategory> findCategoriesByHowType(HowType howType);
	
	public void modifyCategory(ODAccountBookCategory category);
	
	public void modifyCategoriesOrder(List<ODAccountBookCategory> categories);
	
	/**
	 * 분류를 삭제한다.
	 * 
	 * @param oId
	 */
	public void removeCategory(long oId);
	
	public void removeSubCategories(ODAccountBookCategory category);
}
