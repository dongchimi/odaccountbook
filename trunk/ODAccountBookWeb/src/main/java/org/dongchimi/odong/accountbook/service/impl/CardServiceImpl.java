package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.CardCompanyType;
import org.dongchimi.odong.accountbook.domain.CardRepository;
import org.dongchimi.odong.accountbook.domain.CreditCardUsePeriod;
import org.dongchimi.odong.accountbook.domain.CreditCardUsePeriodRepository;
import org.dongchimi.odong.accountbook.domain.DayType;
import org.dongchimi.odong.accountbook.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CreditCardUsePeriodRepository creditCardUsePeriodRepository;

    @Override
    public CreditCardUsePeriod getCreditCardUsePeriod(CardCompanyType cardCompanyType,
            DayType settlementDay) {
        List<CreditCardUsePeriod> creditCardUsePeriods = creditCardUsePeriodRepository
                .findByCardCompanyTypeAndSettlementDay(cardCompanyType, settlementDay);
        if (CollectionUtils.isEmpty(creditCardUsePeriods)) {
            return null;
        }
        return creditCardUsePeriods.get(0);
    }

    @Override
    public void registerCard(Card card) {
        cardRepository.save(card);
    }
}
