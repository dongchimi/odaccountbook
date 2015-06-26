package org.dongchimi.odong.accountbook.web.resource;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.domain.ODUser;
import org.dongchimi.odong.accountbook.dto.ODAccountBookLogDto;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.dongchimi.odong.accountbook.service.ODAccountBookLogService;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.dongchimi.odong.accountbook.web.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/apis/booklogs")
public class ODAccountBookLogResource {
	
	//private static final Logger logger = LoggerFactory.getLogger(ODAccountBookLogResource.class);

	@Autowired
	private ODAccountBookLogService accountBookLogService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
     * 유형 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getHowTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getHowTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(HowType.values());
    }
    
    /**
     * 가계부 등록
     * 
     * @param session
     * @param bookLog
     * @return
     */
    @RequestMapping(value = "/setAccountBookLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setBookLog(HttpSession session, @RequestBody ODAccountBookLog bookLog) {
        
        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        ODUser currentUser = (ODUser) session.getAttribute(SessionManager.SESSION_KEY_SIGN_IN_USER);
        
        bookLog.setAccountBookOid(currentAccountBookOid);
        bookLog.setUserOid(currentUser.getOid());
        
        accountBookLogService.registerAccountBookLog(bookLog);
        return ODRequestResultBuilder.getSuccessRequestResult();
    }
    
    /**
     * 가계부 내역 조회
     * 
     * @param session
     * @param fromDate
     * @param toDate
     * @return
     */
    @RequestMapping(value = "/getAccountBookLogs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getAccountBookLogs(HttpSession session, @RequestParam String fromDate, @RequestParam String toDate) {
        List<ODAccountBookLogDto> accountBookLogs = accountBookLogService.findAccountBookLogDtos(fromDate, toDate);
        return ODRequestResultBuilder.getSuccessRequestResult(accountBookLogs);
    }
    
    /**
     * 가계부 조회
     * 
     * @param session
     * @param oid
     * @return
     */
    @RequestMapping(value = "/getAccountBookLog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getAccountBookLog(HttpSession session, @RequestParam Long oid) {
        return ODRequestResultBuilder.getSuccessRequestResult(accountBookLogService.getAccountBookLog(oid));
    }
    
    /**
     * 내역 삭제
     * 
     * @param session
     * @param oid
     * @return
     */
    @RequestMapping(value = "/deleteAccountBookLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult deleteAccountBookLog(HttpSession session, long oid) {
        accountBookLogService.removeAccountBookLog(oid);
        return ODRequestResultBuilder.getSuccessRequestResult();
    }
}
