package com.spring_arch.login.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring_arch.login.dao.LoginSessionDao;
import com.spring_arch.login.service.LoginService;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name="LoginSessionDao")
	private LoginSessionDao loginSessionDao;
	
	@Override
	public boolean validLogin(HashMap<String, String> loginIdPw) throws Exception {
		long isLoginId = loginSessionDao.validUser(loginIdPw);
		
		if ( isLoginId > 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
