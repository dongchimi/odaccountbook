package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.service.dto.ODAccountBookLogDto;
import org.springframework.stereotype.Service;

@Service
public interface ODAccountBookLogService {
    
	/**
	 * 가계부를 등록한다.
	 * 
	 * @param log
	 */
	public void registerAccountBookLog(ODAccountBookLog log);
	
	/**
	 * 가계부 내역을 조회한다.
	 * 
	 * @param fromDate
	 * @param toDate
	 */
	public List<ODAccountBookLogDto> findAccountBookLogDtos(String fromDate, String toDate);

    /**
     * 가계부를 조회한다.
     * 
     * @param oid
     * @return
     */
    public ODAccountBookLog getAccountBookLog(long oid);
}
