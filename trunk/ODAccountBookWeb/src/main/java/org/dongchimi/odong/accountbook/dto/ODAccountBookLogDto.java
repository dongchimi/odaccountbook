package org.dongchimi.odong.accountbook.dto;

import java.io.Serializable;

import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;

public class ODAccountBookLogDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = -6926763343445271320L;

    /** oid */
    private long oid;

    /** 언제 */
    private String whenDate;

    /** 무엇을 */
    private String what;

    /** 얼마나 */
    private int howmuch;

    /** 메모 */
    private String memo;

    /** 대분류 */
    private String categoryName;

    /** 소분류 */
    private String subCategoryName;

    /** 계좌 */
    private String assetName;

    public static ODAccountBookLogDto toODAccountBookLogDto(ODAccountBookLog accountBookLog) {
        ODAccountBookLogDto dto = new ODAccountBookLogDto();

        dto.setOid(accountBookLog.getOid());
        dto.setWhenDate(accountBookLog.getWhenDate());
        dto.setWhat(accountBookLog.getWhat());
        dto.setHowmuch(accountBookLog.getHowmuch());
        dto.setMemo(accountBookLog.getMemo());

        return dto;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
