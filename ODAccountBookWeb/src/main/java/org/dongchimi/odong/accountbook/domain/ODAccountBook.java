package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "TB_ODACCOUNT_BOOK")
public class ODAccountBook {

    /** 기본 월 기준일 */
    @Transient
    private static final int USER_BASE_DAY = 1;

    @Id
    @GeneratedValue
    private Long oid;

    @Column
    private String name;

    /** 기준일 */
    @Column
    private int baseDay;

    /** 휴일시옵션 */
    @Column
    @Enumerated(EnumType.STRING)
    private HolidayOptionType holidayOptionType;

    /** 메모 */
    @Column
    private String memo;

    /** 가계부 권한 */
    // @OneToMany(cascade = CascadeType.ALL, targetEntity =
    // ODAccountBookAuth.class)
    // @JsonBackReference
    // private List<ODAccountBookAuth> auths = new
    // ArrayList<ODAccountBookAuth>(1);

    // 자산
    // @OneToMany(cascade = CascadeType.ALL, targetEntity = Asset.class)
    // @JoinColumn(name="card_oid")
    // private List<Asset> assets;

    // 카드
    // @OneToMany(cascade = CascadeType.ALL, targetEntity = Card.class)
    // @JoinColumn(name="card_oid")
    // private List<Card> cards;

//    @OneToMany(cascade = CascadeType.ALL, targetEntity = ODAccountBookLog.class)
//    @JoinColumn(name = "relatedBook_oid", referencedColumnName = "oid")
//    @JsonManagedReference
//    private List<ODAccountBookLog> bookLogs;

    public ODAccountBook() {
    }

    public ODAccountBook(String name) {
        baseDay = USER_BASE_DAY;
        this.name = name;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public void addAuth(ODAccountBookAuth auth) {
    // auths.add(auth);
    // }
    //
    // public List<ODAccountBookAuth> getAuths() {
    // return auths;
    // }
    //
    // public void setAuths(List<ODAccountBookAuth> auths) {
    // this.auths = auths;
    // }

    public int getBaseDay() {
        return baseDay;
    }

    public void setBaseDay(int baseDay) {
        this.baseDay = baseDay;
    }

    public HolidayOptionType getHolidayOptionType() {
        return holidayOptionType;
    }

    public void setHolidayOptionType(HolidayOptionType holidayOptionType) {
        this.holidayOptionType = holidayOptionType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

//    public List<ODAccountBookLog> getBookLogs() {
//        return bookLogs;
//    }
//
//    public void setBookLogs(List<ODAccountBookLog> bookLogs) {
//        this.bookLogs = bookLogs;
//    }

}
