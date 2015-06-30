package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    public List<Card> findByAccountBookOidAndCardType(Long accountBookOid, CardType cardType);
    
}
