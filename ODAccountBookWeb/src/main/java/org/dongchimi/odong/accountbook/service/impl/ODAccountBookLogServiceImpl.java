package org.dongchimi.odong.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dongchimi.odong.accountbook.domain.Category;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLogRepository;
import org.dongchimi.odong.accountbook.dto.ODAccountBookLogDto;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.dongchimi.odong.accountbook.service.ODAccountBookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODAccountBookLogServiceImpl implements ODAccountBookLogService {
	
	@Autowired
	private ODAccountBookLogRepository logRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public void registerAccountBookLog(ODAccountBookLog log) {
		logRepository.save(log);
	}

    @Override
    public List<ODAccountBookLogDto> findAccountBookLogDtos(String fromDate, String toDate) {
        List<ODAccountBookLog> accountBookLogs = logRepository.findByWhenDateBetween(fromDate, toDate);
        
        List<ODAccountBookLogDto> result = new ArrayList<ODAccountBookLogDto>();
        for (ODAccountBookLog accountBookLog : accountBookLogs) {
            ODAccountBookLogDto accountBookLogDto = ODAccountBookLogDto.toODAccountBookLogDto(accountBookLog);
            
//            if (accountBookLog.getRelatedCategory() != null && accountBookLog.getRelatedCategory().getParentCategoryOid() != null) {
//                Category parentCategory = categoryService.getCategory(accountBookLog.getRelatedCategory().getParentCategoryOid());
//                accountBookLogDto.setCategoryName(parentCategory.getName());
//            }
            
            result.add(accountBookLogDto);
        }
        return result;
    }

    @Override
    public ODAccountBookLog getAccountBookLog(long oid) {
        return logRepository.findOne(oid);
    }
}
