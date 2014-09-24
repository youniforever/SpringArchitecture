package com.spring_arch.login.service;

import java.util.HashMap;

public interface LoginService {

	boolean validLogin(HashMap<String, String> loginIdPw) throws Exception;

}
