package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODAccountBookAuth;
import org.springframework.stereotype.Service;

@Service
public interface ODAccountBookAuthService {

    public ODAccountBookAuth registerAccountBookAuth(ODAccountBookAuth auth);
    
    public List<ODAccountBookAuth> findAccountBookAuthByUserOid(Long userOid);
}
