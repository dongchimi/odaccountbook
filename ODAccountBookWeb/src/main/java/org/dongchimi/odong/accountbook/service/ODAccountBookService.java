package org.dongchimi.odong.accountbook.service;

import org.dongchimi.odong.accountbook.domain.ODAccountBook;
import org.springframework.stereotype.Service;

@Service
public interface ODAccountBookService {
    
	public ODAccountBook registerAccountBook(ODAccountBook book);
	
	public ODAccountBook getODAccountBook(long oid);

	public void modifyAccountBook(ODAccountBook accountBook);
	
}
