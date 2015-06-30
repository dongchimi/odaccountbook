package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CardType;
import org.dongchimi.odong.accountbook.domain.CreditCardUsePeriod;
import org.dongchimi.odong.accountbook.domain.DayType;
import org.dongchimi.odong.accountbook.dto.CardDto;
import org.springframework.stereotype.Service;

@Service
public interface CardService {

    /**
     * 카드사별 이용기간 조회
     * 
     * @param cardCompanyType
     * @return
     */
    public CreditCardUsePeriod getCreditCardUsePeriod(CardCompanyType cardCompanyType, DayType settlementDay);

    /**
     * 카드를 등록한다.
     * 
     * @param card
     */
    public void registerCard(Card card);

    /**
     * 카드를 조회한다.
     * 
     * @param accountBookOid
     * @return
     */
    public List<CardDto> findCardDtos(Long accountBookOid, CardType cardType);
}
