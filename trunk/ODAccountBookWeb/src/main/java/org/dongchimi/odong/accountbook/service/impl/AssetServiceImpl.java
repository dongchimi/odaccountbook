package org.dongchimi.odong.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.AssetRepository;
import org.dongchimi.odong.accountbook.dto.AssetDto;
import org.dongchimi.odong.accountbook.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<AssetDto> findAssetDtos(long accountBookOid) {
        List<Asset> assets = assetRepository.findByAccountBookOid(accountBookOid);

        List<AssetDto> assetDtos = new ArrayList<AssetDto>();
        for (Asset asset : assets) {
            assetDtos.add(AssetDto.toAssetDto(asset));
        }

        return assetDtos;
    }

    @Override
    public AssetDto getAssetDto(long oid) {
        return AssetDto.toAssetDto(assetRepository.findOne(oid));
    }

    @Override
    public Asset registerAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public void removeAsset(long oid) {
        assetRepository.delete(oid);
    }

}
