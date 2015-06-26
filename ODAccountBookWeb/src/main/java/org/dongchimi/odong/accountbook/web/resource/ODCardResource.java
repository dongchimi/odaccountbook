package org.dongchimi.odong.accountbook.web.resource;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.CardType;
import org.dongchimi.odong.accountbook.domain.CreditCardPaymentMonthType;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis/cards")
public class ODCardResource {

    /**
     * 카드유형 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCardTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCardTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(CardType.values());
    }
    
    /**
     * 일시불/할부 이용기간 월유형 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCreditCardOncePaymentMonthTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCreditCardOncePaymentMonthTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(CreditCardPaymentMonthType.values());
    }
}
