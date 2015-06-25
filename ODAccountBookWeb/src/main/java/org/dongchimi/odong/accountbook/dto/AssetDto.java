package org.dongchimi.odong.accountbook.dto;

import java.io.Serializable;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.AssetType;

public class AssetDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = -1809748534600664605L;

    private Long oid;

    // 이름
    private String name;

    // 자산유형
    private AssetType assetType;

    // 메모
    private String memo;

    // 가계부ID
    private long accountBookOid;

    // 잔액
    private int balance;

    /**
     * @param asset
     * @return AssetDto
     */
    public static AssetDto toAssetDto(Asset asset) {
        AssetDto dto = new AssetDto();

        dto.setOid(asset.getOid());
        dto.setName(asset.getName());
        dto.setAssetType(asset.getAssetType());
        dto.setMemo(asset.getMemo());
        dto.setAccountBookOid(asset.getAccountBookOid());
        dto.setBalance(asset.getBalance());

        return dto;
    }

    /**
     * @return Asset
     */
    public Asset toAsset() {
        Asset asset = new Asset();

        asset.setOid(this.oid);
        asset.setName(this.name);
        asset.setAssetType(this.assetType);
        asset.setMemo(this.memo);
        asset.setAccountBookOid(this.accountBookOid);
        asset.setBalance(this.balance);

        return asset;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
