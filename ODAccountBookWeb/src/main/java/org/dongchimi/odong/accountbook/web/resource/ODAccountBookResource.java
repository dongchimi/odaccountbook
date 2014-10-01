package org.dongchimi.odong.accountbook.web.resource;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.ODAccountBook;
import org.dongchimi.odong.accountbook.service.ODAccountBookLogService;
import org.dongchimi.odong.accountbook.service.ODAccountBookService;
import org.dongchimi.odong.accountbook.web.util.DateUtil;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.dongchimi.odong.accountbook.web.util.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/apis/books")
public class ODAccountBookResource {
	
	private static final Logger logger = LoggerFactory.getLogger(ODAccountBookResource.class);
	@Autowired
	private ODAccountBookService bookService;
	
	@Autowired
	private ODAccountBookLogService logService;
	
	/**
	 * 기본 가계부 조회
	 * @return
	 */
	@RequestMapping(value="/getCurrentAccountBookWithThisMonthLogs", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ODRequestResult getCurrentAccountBookWithThisMonthLogs(HttpSession session) {
		Long currentAccountBookOid = (Long) session.getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
		
		ODAccountBook currentODAccountBook = bookService.getODAccountBook(currentAccountBookOid);

		int baseDay = currentODAccountBook.getBaseDay();
		String startDate = DateUtil.getStartDateByBaseDay(baseDay);
		String endDate = DateUtil.getEndDateByBaseDay(baseDay);
		
		return ODRequestResultBuilder.getSuccessRequestResult(currentODAccountBook);
	}
}
