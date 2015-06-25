package org.dongchimi.odong.accountbook.dto;

import java.io.Serializable;
import java.util.List;

import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.domain.CategoryType;
import org.dongchimi.odong.accountbook.domain.HowType;

public class CategoryDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = -8936316776958119812L;

    /** oid */
    private Long oid;

    /** 수입,지출,저축 구분 */
    private HowType howType;

    /** 항목,그룹 구분 */
    private CategoryType categoryType;

    /** 분류명 */
    private String name;

    /** 메모 */
    private String memo;

    /** 정렬순서 */
    private int sortNumber;

    /** 상위분류ID */
    private Long parentCategoryOid;

    /** 가계부ID */
    private Long accountBookOid;

    /** 하위분류 */
    private List<CategoryDto> subCategories;

    /**
     * Category 도메인 객체를 CategoryDto 객체로 변환한다.
     * 
     * @param category
     * @return
     */
    public static CategoryDto toCategoryDto(Category category) {
        if (category == null) return null;
        
        CategoryDto dto = new CategoryDto();

        dto.setOid(category.getOid());
        dto.setHowType(category.getHowType());
        dto.setCategoryType(category.getCategoryType());
        dto.setName(category.getName());
        dto.setMemo(category.getMemo());
        dto.setSortNumber(category.getSortNumber());
        dto.setAccountBookOid(category.getAccountBookOid());
        dto.setParentCategoryOid(category.getParentCategoryOid());

        return dto;
    }

    /**
     * CategoryDto 객체를 Category 도메인 객체로 변환한다.
     * 
     * @return
     */
    public Category toCategory() {
        Category category = new Category();

        category.setOid(this.oid);
        category.setHowType(this.howType);
        category.setCategoryType(this.categoryType);
        category.setName(this.name);
        category.setMemo(this.memo);
        category.setSortNumber(this.sortNumber);
        category.setAccountBookOid(this.accountBookOid);
        category.setParentCategoryOid(this.parentCategoryOid);

        return category;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public HowType getHowType() {
        return howType;
    }

    public void setHowType(HowType howType) {
        this.howType = howType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(int sortNumber) {
        this.sortNumber = sortNumber;
    }

    public List<CategoryDto> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<CategoryDto> subCategories) {
        this.subCategories = subCategories;
    }

    public Long getAccountBookOid() {
        return accountBookOid;
    }

    public void setAccountBookOid(Long accountBookOid) {
        this.accountBookOid = accountBookOid;
    }

    public Long getParentCategoryOid() {
        return parentCategoryOid;
    }

    public void setParentCategoryOid(Long parentCategoryOid) {
        this.parentCategoryOid = parentCategoryOid;
    }

}
