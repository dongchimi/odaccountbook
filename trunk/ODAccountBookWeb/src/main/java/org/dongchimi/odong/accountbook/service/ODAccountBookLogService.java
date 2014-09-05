package org.dongchimi.odong.accountbook.service;

import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.springframework.stereotype.Service;

@Service
public interface ODAccountBookLogService {
	void registerODAccountBookLog(ODAccountBookLog log);
}
