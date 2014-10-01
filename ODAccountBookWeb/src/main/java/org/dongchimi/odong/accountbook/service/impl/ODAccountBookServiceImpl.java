package org.dongchimi.odong.accountbook.service.impl;

import org.dongchimi.odong.accountbook.domain.ODAccountBook;
import org.dongchimi.odong.accountbook.domain.ODAccountBookRepository;
import org.dongchimi.odong.accountbook.service.ODAccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODAccountBookServiceImpl implements ODAccountBookService {
	
	@Autowired
	ODAccountBookRepository bookRepository;
	
	@Override
	public ODAccountBook getODAccountBook(long oid) {
		return bookRepository.findOne(oid);
	}
}
