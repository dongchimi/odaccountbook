package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODAccountBookAuth;
import org.dongchimi.odong.accountbook.domain.ODAccountBookAuthRepository;
import org.dongchimi.odong.accountbook.service.ODAccountBookAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODAccountBookAuthServiceImpl implements ODAccountBookAuthService {

    @Autowired
    private ODAccountBookAuthRepository accountBookAuthRepository;
    
    @Override
    public ODAccountBookAuth registerAccountBookAuth(ODAccountBookAuth auth) {
        return accountBookAuthRepository.save(auth);
    }

    @Override
    public List<ODAccountBookAuth> findAccountBookAuthByUserOid(Long userOid) {
        return accountBookAuthRepository.findByUserOid(userOid);
    }

}
