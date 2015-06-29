package org.dongchimi.odong.accountbook.web.resource;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CardType;
import org.dongchimi.odong.accountbook.domain.CreditCardPaymentMonthType;
import org.dongchimi.odong.accountbook.domain.DayType;
import org.dongchimi.odong.accountbook.service.CardService;
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
@RequestMapping(value = "/apis/cards")
public class ODCardResource {

    @Autowired
    private CardService cardService;

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
     * 카드사 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCardCompanyTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCardCompanyTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(CardCompanyType.values());
    }

    /**
     * 날짜유형 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getDayTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getDayTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(DayType.values());
    }

    /**
     * 일시불/할부 이용기간 월유형 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCreditCardPaymentMonthTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCreditCardPaymentMonthTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(CreditCardPaymentMonthType.values());
    }

    /**
     * 카드사와 결제일자별 이용기간 조회
     * 
     * @param session
     * @param cardCompanyType
     * @param settlementDay
     * @return
     */
    @RequestMapping(value = "/getCreditCardUsePeriod", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCreditCardUsePeriod(HttpSession session, String cardCompanyType,
            Integer settlementDay) {
        return ODRequestResultBuilder.getSuccessRequestResult(cardService.getCreditCardUsePeriod(
                CardCompanyType.toCardCompanyType(cardCompanyType),
                DayType.toDayType(settlementDay)));
    }

    @RequestMapping(value = "/setCreditCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setCard(HttpSession session, @RequestBody Card card) {
        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    @RequestMapping(value = "/setCheckCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setCard(HttpSession session, @RequestParam String name,
            @RequestParam String memo, @RequestParam Long assetOid) {
        
        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        
        Card checkCard = new Card();
        checkCard.setCardType(CardType.CHECK_CARD);
        checkCard.setNickName(name);
        checkCard.setMemo(memo);
        checkCard.setAssetOid(assetOid);
        checkCard.setAccountBookOid(currentAccountBookOid);
        
        cardService.registerCard(checkCard);
        
        return ODRequestResultBuilder.getSuccessRequestResult();
    }

}
