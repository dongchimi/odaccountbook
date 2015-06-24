package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.AssetRepository;
import org.dongchimi.odong.accountbook.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<Asset> findAssets(long accountBookOid) {
        return assetRepository.findByAccountBookOid(accountBookOid);
    }

    @Override
    public Asset registerAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public void removeAsset(long oid) {
        assetRepository.delete(oid);
    }

    @Override
    public Asset getAsset(long oid) {
        return assetRepository.findOne(oid);
    }

}
