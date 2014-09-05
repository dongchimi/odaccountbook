package org.dongchimi.odong.accountbook.service;

import org.dongchimi.odong.accountbook.domain.ODAccountBook;
import org.springframework.stereotype.Service;

@Service
public interface ODAccountBookService {
	void registerODAccountBook(ODAccountBook book);
}
