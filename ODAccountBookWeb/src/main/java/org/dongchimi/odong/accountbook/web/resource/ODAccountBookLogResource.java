package org.dongchimi.odong.accountbook.web.resource;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.HowType;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/apis/booklogs")
public class ODAccountBookLogResource {
	
	private static final Logger logger = LoggerFactory.getLogger(ODAccountBookLogResource.class);

	/**
	 * 기본 가계부 조회
	 * @return
	 */
	@RequestMapping(value="/registerBookLog", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	ODRequestResult registerBookLog(@RequestParam Long bookOid, @RequestParam String howType, HttpSession session) {
//		ODUser user = (ODUser) session.getAttribute("signinUser");
//		AccountBook book = user.getAccountBookByOid(bookOid);
		HowType howTypeE = HowType.valueOf(howType);
		
		logger.info(howTypeE.toString());
		
		return ODRequestResultBuilder.getSuccessRequestResult();
	}
}
