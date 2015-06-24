package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.springframework.stereotype.Service;

@Service
public interface AssetService {

    /**
     * 가계부에 등록된 자산을 조회한다.
     * 
     * @param currentAccountBookOid
     */
    public List<Asset> findAssets(long accountBookOid);

    /**
     * 자산을 조회한다.
     * 
     * @param parseLong
     * @return
     */
    public Asset getAsset(long oid);
    
    /**
     * 자산을 등록한다.
     * 
     * @param asset
     */
    public Asset registerAsset(Asset asset);

    /**
     * 자산을 삭제한다.
     * 
     * @param oId
     */
    public void removeAsset(long oid);

	
}
