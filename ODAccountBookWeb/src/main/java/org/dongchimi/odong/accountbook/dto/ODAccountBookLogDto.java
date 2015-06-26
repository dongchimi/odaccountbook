package org.dongchimi.odong.accountbook.dto;

import java.io.Serializable;

import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;

public class ODAccountBookLogDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = -6926763343445271320L;

    /** oid */
    private long oid;

    /** 언제 */
    private String whenDate;

    /** 어떻게 */
    private HowType how;

    /** 무엇을 */
    private String what;

    /** 얼마나 */
    private int howmuch;

    /** 메모 */
    private String memo;

    /** 대분류ID */
    private Long categoryOid;

    /** 대분류명 */
    private String categoryName;

    /** 소분류ID */
    private Long subCategoryOid;

    /** 소분류명 */
    private String subCategoryName;

    /** 자산ID */
    private Long assetOid;

    /** 자산명 */
    private String assetName;

    /** 가계부ID */
    private Long accountBookOid;

    /** 작성자ID */
    private Long userOid;

    public static ODAccountBookLogDto toODAccountBookLogDto(ODAccountBookLog accountBookLog) {
        ODAccountBookLogDto dto = new ODAccountBookLogDto();

        dto.setOid(accountBookLog.getOid());
        dto.setWhenDate(accountBookLog.getWhenDate());
        dto.setHow(accountBookLog.getHow());
        dto.setWhat(accountBookLog.getWhat());
        dto.setHowmuch(accountBookLog.getHowmuch());
        dto.setMemo(accountBookLog.getMemo());
        dto.setAccountBookOid(accountBookLog.getAccountBookOid());
        dto.setAssetOid(accountBookLog.getAssetOid());
        dto.setCategoryOid(accountBookLog.getCategoryOid());
        dto.setSubCategoryOid(accountBookLog.getSubCategoryOid());

        return dto;
    }

    public ODAccountBookLog toODAccountBookLog() {
        ODAccountBookLog accountBookLog = new ODAccountBookLog();

        accountBookLog.setOid(oid);
        accountBookLog.setWhenDate(whenDate);
        accountBookLog.setHow(how);
        accountBookLog.setWhat(what);
        accountBookLog.setHowmuch(howmuch);
        accountBookLog.setMemo(memo);
        accountBookLog.setCategoryOid(categoryOid);
        accountBookLog.setSubCategoryOid(subCategoryOid);
        accountBookLog.setAccountBookOid(accountBookOid);
        accountBookLog.setUserOid(userOid);

        return accountBookLog;
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

    public HowType getHow() {
        return how;
    }

    public void setHow(HowType how) {
        this.how = how;
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

    public Long getCategoryOid() {
        return categoryOid;
    }

    public void setCategoryOid(Long categoryOid) {
        this.categoryOid = categoryOid;
    }

    public Long getSubCategoryOid() {
        return subCategoryOid;
    }

    public void setSubCategoryOid(Long subCategoryOid) {
        this.subCategoryOid = subCategoryOid;
    }

    public Long getAssetOid() {
        return assetOid;
    }

    public void setAssetOid(Long assetOid) {
        this.assetOid = assetOid;
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

}
