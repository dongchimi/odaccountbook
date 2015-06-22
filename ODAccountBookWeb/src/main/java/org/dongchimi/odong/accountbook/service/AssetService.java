package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.springframework.stereotype.Service;

@Service
public interface AssetService {

    /**
     * 자산을 조회한다.
     * 
     * @param currentAccountBookOid
     */
    public List<Asset> findAssets(long accountBookOid);

    public void registerAsset(Asset asset);
	
}
