package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "TB_CATEGORY")
public class Category {

    @Id
    @GeneratedValue
    private Long oid;

    /** 수입,지출,저축 구분 */
    @Enumerated(EnumType.STRING)
    private HowType howType;

    /** 항목,그룹 구분 */
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    /** 분류명 */
    @Column
    private String name;

    /** 메모 */
    @Column
    private String memo;

    /** 정렬순서 */
    @Column
    private int sortNumber = 999;

    /** 상위분류ID */
    @Column(nullable = true)
    private Long parentCategoryOid;

    /** 가계부ID */
    @Column
    private Long accountBookOid;

    public Category() {
    }

    public Category(HowType howType, CategoryType categoryType, String name, String memo,
            Long accountBookOid, Long parentCategoryOid) {
        this.howType = howType;
        this.categoryType = categoryType;
        this.name = name;
        this.memo = memo;
        this.accountBookOid = accountBookOid;
        this.parentCategoryOid = parentCategoryOid;
    }
    
    public static Category createDefaultGroup(HowType howType, Long accountBookOid) {
        Category category = new Category();
        
        category.setHowType(howType);
        category.setCategoryType(CategoryType.GROUP);
        category.setName("그룹없음");
        category.setAccountBookOid(accountBookOid);
        
        return category;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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

    public HowType getHowType() {
        return howType;
    }

    public void setHowType(HowType howType) {
        this.howType = howType;
    }

    public Long getParentCategoryOid() {
        return parentCategoryOid;
    }

    public void setParentCategoryOid(Long parentCategoryOid) {
        this.parentCategoryOid = parentCategoryOid;
    }

    public Long getAccountBookOid() {
        return accountBookOid;
    }

    public void setAccountBookOid(Long accountBookOid) {
        this.accountBookOid = accountBookOid;
    }

}
