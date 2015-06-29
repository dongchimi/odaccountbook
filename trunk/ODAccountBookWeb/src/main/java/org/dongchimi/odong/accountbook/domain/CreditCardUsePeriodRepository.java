package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardUsePeriodRepository extends JpaRepository<CreditCardUsePeriod, Long> {

    public List<CreditCardUsePeriod> findByCardCompanyTypeAndSettlementDay(CardCompanyType cardCompanyType, DayType settlementDay);
}
