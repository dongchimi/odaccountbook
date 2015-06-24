package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODUser;
import org.springframework.stereotype.Service;

@Service
public interface ODUserService {
	
    public ODUser registerODUser(ODUser user);
	
	List<ODUser> findODUserAll();
	boolean isExistingEmail(String email);
	/**
	 * 로그인 
	 * @param email 	이메일
	 * @param password	비밀번호
	 * @return
	 */
	ODUser signin(String email, String password);
}
