package org.dongchimi.odong.accountbook.service.impl;

import org.dongchimi.odong.accountbook.domain.CardRepository;
import org.dongchimi.odong.accountbook.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
}
