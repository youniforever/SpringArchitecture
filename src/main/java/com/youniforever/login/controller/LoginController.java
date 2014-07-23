package com.youniforever.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youniforever.common.lib.message.MessageSetter;
import com.youniforever.common.lib.session.SessionUtil;

@Controller
public class LoginController {
	
	@Resource(name="MessageSetter")
	private MessageSetter messageSetter;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loadLogin(HttpServletRequest request) throws Exception {
		SessionUtil.remove(request);;

		return "login/login";
	}
	
	@RequestMapping(value="/login.json", method=RequestMethod.POST)
	public String getLoginValid(HttpServletRequest request, Model model) throws Exception {
		SessionUtil.set(request);
		messageSetter.message0000(model, "");
		return "jsonViewer";
	}
}
