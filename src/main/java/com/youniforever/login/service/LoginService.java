package com.youniforever.login.service;

import java.util.HashMap;

public interface LoginService {

	boolean validLogin(HashMap<String, String> loginIdPw) throws Exception;

}
