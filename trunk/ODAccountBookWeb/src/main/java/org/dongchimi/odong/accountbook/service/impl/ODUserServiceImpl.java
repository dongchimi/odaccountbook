package org.dongchimi.odong.accountbook.service.impl;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODUser;
import org.dongchimi.odong.accountbook.domain.ODUserRepository;
import org.dongchimi.odong.accountbook.service.ODUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ODUserServiceImpl implements ODUserService {
	
	@Autowired
	ODUserRepository odUserRepository;

	@Override
	public void registerODUser(ODUser user) {
		odUserRepository.save(user);
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
		if (foundODUser == null || foundODUser.equaslsPassword(password) == false){
			return null;
		}
		return foundODUser;
	}
}
