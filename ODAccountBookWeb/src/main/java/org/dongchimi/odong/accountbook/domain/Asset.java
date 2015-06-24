package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "TB_ASSET")
public class Asset {

    @Id
    @GeneratedValue
    private Long oid;

    // 이름
    @Column(nullable = true)
    private String name;

    // 별칭
    @Column(nullable = true)
    private String nickName;

    // 자산유형
    @Column
    @Enumerated(EnumType.STRING)
    private AssetType assetType;

    // 메모
    @Column
    private String memo;

    // 가계부ID
    @Column
    private long accountBookOid;

    @OneToMany
    @JsonManagedReference
    private List<ODAccountBookLog> accountBookLogs;

    // 잔액
    @Transient
    private int balance;

    // 연관된 체크카드
    // @OneToOne(cascade = CascadeType.ALL, targetEntity = Card.class)
    // @JoinColumn(name="card_oid")
    // private Card relatedCard;

    public Asset() {
    }

    public Asset(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public Asset(AssetType assetType, String name, String memo, long accountBookOid) {
        this.assetType = assetType;
        this.name = name;
        this.memo = memo;
        this.accountBookOid = accountBookOid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void out(String when, String what, int howmuch, String who) {
        this.balance -= howmuch;
    }

    public void in(String when, String what, int howmuch, String who) {
        this.balance += howmuch;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public long getAccountBookOid() {
        return accountBookOid;
    }

    public void setAccountBookOid(long accountBookOid) {
        this.accountBookOid = accountBookOid;
    }

    public List<ODAccountBookLog> getAccountBookLogs() {
        return accountBookLogs;
    }

    public void setAccountBookLogs(List<ODAccountBookLog> accountBookLogs) {
        this.accountBookLogs = accountBookLogs;
    }

}
