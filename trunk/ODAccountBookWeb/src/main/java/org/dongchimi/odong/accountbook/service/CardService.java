package org.dongchimi.odong.accountbook.service;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CreditCardUsePeriod;
import org.dongchimi.odong.accountbook.domain.DayType;
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

    public void registerCard(Card card);
}
