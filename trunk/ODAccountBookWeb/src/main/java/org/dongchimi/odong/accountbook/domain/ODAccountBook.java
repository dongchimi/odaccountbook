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
    private Integer baseDay;

    /** 휴일시옵션 */
    @Column
    @Enumerated(EnumType.STRING)
    private HolidayOptionType holidayOptionType;

    /** 메모 */
    @Column
    private String memo;

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

    public Integer getBaseDay() {
        return baseDay;
    }

    public void setBaseDay(Integer baseDay) {
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

}
