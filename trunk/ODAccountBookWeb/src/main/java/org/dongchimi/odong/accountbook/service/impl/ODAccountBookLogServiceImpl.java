package org.dongchimi.odong.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLogRepository;
import org.dongchimi.odong.accountbook.dto.AssetDto;
import org.dongchimi.odong.accountbook.dto.CategoryDto;
import org.dongchimi.odong.accountbook.dto.ODAccountBookLogDto;
import org.dongchimi.odong.accountbook.service.AssetService;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.dongchimi.odong.accountbook.service.ODAccountBookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODAccountBookLogServiceImpl implements ODAccountBookLogService {

    @Autowired
    private ODAccountBookLogRepository logRepository;

    @Autowired
    private AssetService assetService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void registerAccountBookLog(ODAccountBookLog log) {
        logRepository.save(log);
    }

    @Override
    public List<ODAccountBookLogDto> findAccountBookLogDtos(String fromDate, String toDate) {
        List<ODAccountBookLog> accountBookLogs = logRepository.findByWhenDateBetweenOrderByWhenDateDesc(fromDate,
                toDate);

        List<ODAccountBookLogDto> result = new ArrayList<ODAccountBookLogDto>();
        for (ODAccountBookLog accountBookLog : accountBookLogs) {
            ODAccountBookLogDto accountBookLogDto = ODAccountBookLogDto
                    .toODAccountBookLogDto(accountBookLog);

            AssetDto assetDto = assetService.getAssetDto(accountBookLog.getAssetOid());
            accountBookLogDto.setAssetName(assetDto.getName());

            CategoryDto category = categoryService.getCategory(accountBookLog.getCategoryOid());
            accountBookLogDto.setCategoryName(category.getName());

            CategoryDto subCategory = categoryService.getCategory(accountBookLog
                    .getSubCategoryOid());
            accountBookLogDto.setSubCategoryName(subCategory.getName());

            result.add(accountBookLogDto);
        }

        return result;
    }

    @Override
    public ODAccountBookLogDto getAccountBookLog(long oid) {
        return ODAccountBookLogDto.toODAccountBookLogDto(logRepository.findOne(oid));
    }

    @Override
    public void removeAccountBookLog(long oid) {
        logRepository.delete(oid);
    }
}
