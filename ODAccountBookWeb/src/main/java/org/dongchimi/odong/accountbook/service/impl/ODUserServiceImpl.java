package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODAccountBook;
import org.dongchimi.odong.accountbook.domain.ODAccountBookAuth;
import org.dongchimi.odong.accountbook.domain.ODUser;
import org.dongchimi.odong.accountbook.domain.ODUserRepository;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.dongchimi.odong.accountbook.service.ODAccountBookAuthService;
import org.dongchimi.odong.accountbook.service.ODAccountBookService;
import org.dongchimi.odong.accountbook.service.ODUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODUserServiceImpl implements ODUserService {

    @Autowired
    private ODUserRepository odUserRepository;
    
    @Autowired
    private ODAccountBookService accountBookService;
    
    @Autowired
    private ODAccountBookAuthService accountBookAuthService;
    
    @Autowired
    private CategoryService categoryService;

    @Override
    public ODUser registerODUser(ODUser user) {
        // 사용자 등록
        ODUser registeredUser = odUserRepository.save(user);

        // 기본가계부 생성
        ODAccountBook registeredBook = accountBookService.registerAccountBook(new ODAccountBook("기본가계부"));

        // 권한 생성
        ODAccountBookAuth auth = ODAccountBookAuth.createReadWriteAccountBookAuth(
                registeredUser.getOid(), registeredBook.getOid());
        auth.setDefaultBookAuth(true);
        
        accountBookAuthService.registerAccountBookAuth(auth);
        categoryService.registerDefaultCategory(registeredBook.getOid());

        return registeredUser;
    }

    @Override
    public List<ODUser> findODUserAll() {
        return null;
    }

    @Override
    public boolean isExistingEmail(String email) {
        ODUser foundODUser = odUserRepository.findByEmail(email);
        return foundODUser != null ? true : false;
    }

    @Override
    public ODUser signin(String email, String password) {
        ODUser foundODUser = odUserRepository.findByEmail(email);
        if (foundODUser == null || foundODUser.equaslsPassword(password) == false) {
            return null;
        }
        return foundODUser;
    }
}
