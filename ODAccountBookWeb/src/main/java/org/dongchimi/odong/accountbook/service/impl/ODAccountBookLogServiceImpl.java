package org.dongchimi.odong.accountbook.service.impl;

import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLogRepository;
import org.dongchimi.odong.accountbook.service.ODAccountBookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODAccountBookLogServiceImpl implements ODAccountBookLogService {
	
	@Autowired
	ODAccountBookLogRepository logRepository;
	
	@Override
	public void registerODAccountBookLog(ODAccountBookLog log) {
		logRepository.save(log);
	}
}
