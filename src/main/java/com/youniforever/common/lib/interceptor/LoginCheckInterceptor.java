package com.youniforever.common.lib.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.youniforever.common.lib.session.SessionUtil;
import com.youniforever.login.dto.LoginSessionDto;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LoginSessionDto loginSession = (LoginSessionDto) SessionUtil.getObject(request);
		
		if ( loginSession != null ) {
			return true;
		}
		else {
			response.sendRedirect("/login.do");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LoginSessionDto loginSession = (LoginSessionDto) SessionUtil.getObject(request);
		
		modelAndView.addObject("loginSession", loginSession);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
	
}
