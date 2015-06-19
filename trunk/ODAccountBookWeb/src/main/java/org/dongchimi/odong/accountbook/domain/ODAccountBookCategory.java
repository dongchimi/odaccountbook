package org.dongchimi.odong.accountbook.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "TB_ODACCOUNT_BOOK_CATEGORY")
public class ODAccountBookCategory {

    @Id
    @GeneratedValue
    private Long oId;

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
    private int sortNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ODAccountBookCategory> subCategories;

    @ManyToOne
    @JsonBackReference
    private ODAccountBookCategory parentCategory;

    public ODAccountBookCategory() {
    }

    public ODAccountBookCategory(String howTypeName, String categoryTypeName, String name,
            String memo) {
        this.howType = HowType.toHowType(howTypeName);
        this.categoryType = CategoryType.toCategoryType(categoryTypeName);
        this.name = name;
        this.memo = memo;
        this.sortNumber = 999;
    }

    public void addSubCategories(ODAccountBookCategory category) {
        if (CollectionUtils.isEmpty(this.subCategories)) {
            this.subCategories = new ArrayList<ODAccountBookCategory>();
        }

        this.subCategories.add(category);
    }
    
    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
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

    public List<ODAccountBookCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<ODAccountBookCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public ODAccountBookCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ODAccountBookCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

}
