package com.myfinalyearproject.validator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfinalyearproject.controller.UserLoginServiceInter;
import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.domain.UserInfoLogin;
import com.myfinalyearproject.repository.UserRepository;

@Service
@Transactional
public class LoginValidator implements  UserLoginServiceInter{
	@Autowired
	private UserRepository userRepo;
	
	
	/* (non-Javadoc)
	 * @see com.financialManagerApp.fMangerApp.Service.UserLoginServiceInter#verifyUser(java.lang.String)
	 */
	@Override
	public boolean verifyUser(UserInfoLogin user) {
		
		
		User userdet = userRepo.findByemail(user.getEmail());
		
		if(userdet != null) {
			System.out.println("not null");
			System.out.println(user.getPassword());
			System.out.println(userdet.getpassword());
			if(userdet.getpassword().equals(user.getPassword())) {
				System.out.println("exists");
			return true;
			}
			System.out.println("not exists");
			return false;
		}
		return false;
	
		
		 
		
	}
	
	private boolean userExist(String username) {
		User userdet = userRepo.findByemail(username);
		if(userdet != null) {
			return true;
		}
		return false;
	}
}
