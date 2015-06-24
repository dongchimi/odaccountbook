package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "TB_ODACCOUNT_BOOK_LOG")
public class ODAccountBookLog { // implements Comparable<ODAccountBookLog>

    @Id
    @GeneratedValue
    private Long oid;

    // 언제
    @Column
    private String whenDate;

    // 무엇을
    @Column
    private String what;

    // 얼마나
    @Column
    private int howmuch;

    // 어떻게
    @Column
    @Enumerated(EnumType.STRING)
    private HowType how;

    // 자산
    @ManyToOne
    @JsonBackReference(value = "ODAccountBookLog-Asset")
    private Asset relatedAsset;

    // 분류
    @ManyToOne
    @JsonBackReference(value = "ODAccountBookLog-Category")
    private Category relatedCategory;

    // 가계부ID
    @Column
    private Long accountBookOid;

    // 작성자ID
    @Column
    private Long userOid;

    // 메모
    @Column
    private String memo;

    // 잔액
    @Transient
    private int balance;
    
    public ODAccountBookLog() {}

    public ODAccountBookLog(Long accountBookOid, HowType how, String whenDate, String what,
            int howmuch, Long userOid) {
        this.accountBookOid = accountBookOid;
        this.how = how;
        this.whenDate = whenDate;
        this.what = what;
        this.howmuch = howmuch;
        this.userOid = userOid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getWhenDate() {
        return whenDate;
    }

    public void setWhenDate(String whenDate) {
        this.whenDate = whenDate;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int getHowmuch() {
        return howmuch;
    }

    public void setHowmuch(int howmuch) {
        this.howmuch = howmuch;
    }

    public HowType getHow() {
        return how;
    }

    public void setHow(HowType how) {
        this.how = how;
    }

    public Asset getRelatedAsset() {
        return relatedAsset;
    }

    public void setRelatedAsset(Asset relatedAsset) {
        this.relatedAsset = relatedAsset;
    }

    public Category getRelatedCategory() {
        return relatedCategory;
    }

    public void setRelatedCategory(Category relatedCategory) {
        this.relatedCategory = relatedCategory;
    }

    public Long getAccountBookOid() {
        return accountBookOid;
    }

    public void setAccountBookOid(Long accountBookOid) {
        this.accountBookOid = accountBookOid;
    }

    public Long getUserOid() {
        return userOid;
    }

    public void setUserOid(Long userOid) {
        this.userOid = userOid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
