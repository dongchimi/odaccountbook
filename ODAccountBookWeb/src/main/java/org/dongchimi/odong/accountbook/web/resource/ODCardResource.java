package org.dongchimi.odong.accountbook.web.resource;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CardType;
import org.dongchimi.odong.accountbook.domain.CreditCardPaymentMonthType;
import org.dongchimi.odong.accountbook.domain.DayType;
import org.dongchimi.odong.accountbook.dto.CardDtoForRegister;
import org.dongchimi.odong.accountbook.service.CardService;
import org.dongchimi.odong.accountbook.web.util.ODException;
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

    /**
     * 신용카드 등록
     * 
     * @param session
     * @param cardDto
     * @return
     */
    @RequestMapping(value = "/setCreditCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setCreditCard(HttpSession session, @RequestBody CardDtoForRegister cardDto) {
        
        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        
        Card card = cardDto.toCard();
        
        card.setAccountBookOid(currentAccountBookOid);
        card.setCardType(CardType.CREDIT_CARD);
        
        cardService.registerCard(card);
        
        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 체크카드 등록
     * 
     * @param session
     * @param nickName
     * @param memo
     * @param assetOid
     * @return
     */
    @RequestMapping(value = "/setCheckCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setCheckCard(HttpSession session, @RequestParam String nickName,
            @RequestParam String memo, @RequestParam Long assetOid) {
        
        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        
        Card checkCard = new Card();
        checkCard.setCardType(CardType.CHECK_CARD);
        checkCard.setNickName(nickName);
        checkCard.setMemo(memo);
        checkCard.setAssetOid(assetOid);
        checkCard.setAccountBookOid(currentAccountBookOid);
        
        cardService.registerCard(checkCard);
        
        return ODRequestResultBuilder.getSuccessRequestResult();
    }
    
    /**
     * 신용카드 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCreditCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCreditCards(HttpSession session) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);

        if (currentAccountBookOid == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("로그인하세요."));
        }

        return ODRequestResultBuilder.getSuccessRequestResult(cardService
                .findCardDtos(currentAccountBookOid, CardType.CREDIT_CARD));
    }
    
    /**
     * 체크카드 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCheckCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getCheckCards(HttpSession session) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);

        if (currentAccountBookOid == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("로그인하세요."));
        }

        return ODRequestResultBuilder.getSuccessRequestResult(cardService
                .findCardDtos(currentAccountBookOid, CardType.CHECK_CARD));
    }

}
