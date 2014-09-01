package com.youniforever.services;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youniforever.login.service.LoginService;


@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceImplTest extends AbstractApplicationContextTest {
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	@Test
	public void test_validLogin() throws Exception {
		HashMap<String,String> loginIdPw = new HashMap<String,String>();
		loginIdPw.put("userId", "youniforever");
		loginIdPw.put("userPw", "dlxotjd6");
		
		long validLogin = 0;
		boolean isValidLogin = loginService.validLogin(loginIdPw);
		if ( isValidLogin )
			validLogin = 1;
		else
			validLogin = 0;
		
		Assert.assertEquals(validLogin, 1);
	}
}
