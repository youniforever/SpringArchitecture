package com.spring_arch.login.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring_arch.common.lib.message.MessageCode;
import com.spring_arch.common.lib.message.MessageSetter;
import com.spring_arch.common.lib.session.SessionUtil;
import com.spring_arch.login.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="MessageSetter")
	private MessageSetter messageSetter;
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loadLogin(HttpServletRequest request) throws Exception {
		SessionUtil.remove(request);;

		return "login/login";
	}
	
	@RequestMapping(value="/login.json", method=RequestMethod.POST)
	public String getLoginValid(HttpServletRequest request, Model model) throws Exception {
		String getUserId = request.getParameter("loginId");
		String getUserPassword = request.getParameter("loginPassword");
		
		HashMap<String,String> loginIdPw = new HashMap<String,String>();
		loginIdPw.put("userId", getUserId);
		loginIdPw.put("userPw", getUserPassword);
		
		boolean isValidLogin = loginService.validLogin(loginIdPw);
		if ( isValidLogin ) {
			SessionUtil.set(request);
			messageSetter.message0000(model, "");
		}
		else {
			messageSetter.messageSet(model, MessageCode.result1000, null, "");
		}
		
		return "jsonViewer";
	}
}
