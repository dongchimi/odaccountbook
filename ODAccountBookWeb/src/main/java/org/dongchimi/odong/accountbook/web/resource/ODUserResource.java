package org.dongchimi.odong.accountbook.web.resource;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.ODAccountBookAuth;
import org.dongchimi.odong.accountbook.domain.ODUser;
import org.dongchimi.odong.accountbook.service.ODAccountBookAuthService;
import org.dongchimi.odong.accountbook.service.ODUserService;
import org.dongchimi.odong.accountbook.web.util.ODException;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.dongchimi.odong.accountbook.web.util.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis/users")
public class ODUserResource {

    private static final Logger logger = LoggerFactory.getLogger(ODUserResource.class);

    @Autowired
    private ODUserService odUserService;

    @Autowired
    private ODAccountBookAuthService odAccountBookAuthService;

    /**
     * 기존 메일이 존재하는가?
     * 
     * @param email
     *            확인메일 주소
     * @return 존재여부
     */
    @RequestMapping(value = "/isExistEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult isExistEmail(@RequestParam String email) {

        boolean hasEmail = odUserService.isExistingEmail(email);
        if (hasEmail == true) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("존재하는 이메일입니다."));
        }

        return ODRequestResultBuilder.getSuccessRequestResult("hasEmail", hasEmail);
    }

    /**
     * 회원가입
     * 
     * @param email
     *            이메일
     * @param password
     *            비밀번호
     * @return 등록성공여부
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult signup(@RequestParam String email, @RequestParam String password) {

        boolean hasEmail = odUserService.isExistingEmail(email);
        if (hasEmail == true) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("존재하는 이메일입니다."));
        }

        odUserService.registerODUser(new ODUser(email, password));

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 로그인
     * 
     * @param email
     *            이메일
     * @param password
     *            비밀번호
     * @return 등록성공여부
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult signin(@RequestParam String email, @RequestParam String password,
            HttpSession session) {

        ODUser user = odUserService.signin(email, password);
        if (user == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("사용자 정보가 없습니다."));
        }
        session.setAttribute(SessionManager.SESSION_KEY_SIGN_IN_USER, user);
        
        List<ODAccountBookAuth> accountBookAuths = odAccountBookAuthService.findAccountBookAuthByUserOid(user.getOid());
        if (CollectionUtils.isEmpty(accountBookAuths)) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("등록된 권한이 없습니다."));
        }
        session.setAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID,
                accountBookAuths.get(0).getAccountBookOid());
        
        return ODRequestResultBuilder.getSuccessRequestResult(user);
    }
}
