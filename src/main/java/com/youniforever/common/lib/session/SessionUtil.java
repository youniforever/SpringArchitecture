package com.youniforever.common.lib.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.youniforever.login.dto.LoginSessionDto;

/**
 * session Util - Spring에서 제공하는 RequestContextHolder 를 이용하여 request 객체를
 * service까지 전달하지 않고 사용할 수 있게 해줌
 *
 */
public class SessionUtil {

	private static String key = "loginSession";

	/**
	 * 세션값을 String으로 반환
	 * 
	 * @param request
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(HttpServletRequest req, String defaultValue) {
		HttpSession session = req.getSession();
		String sessionValue = defaultValue;
		if (session == null) {
			return sessionValue;
		}

		try {
			if (session.getAttribute(key) == null) {
				sessionValue = defaultValue;
			} else {

				sessionValue = (String) session.getAttribute(key);
			}
		} catch (Exception e) {
			sessionValue = defaultValue;
		}
		return sessionValue;
	}

	public static String getString(HttpServletRequest req) {
		return SessionUtil.getString(req, "");
	}

	/**
	 * 세션값을 Object로 반환
	 * 
	 * @param req
	 * @param key
	 * @return
	 */
	public static Object getObject(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		return session.getAttribute(key);
	}

	/**
	 * 세션값을 String으로 설정
	 * 
	 * @param req
	 * @param key
	 * @param value
	 */
	public static void set(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		LoginSessionDto loginSessionDto = new LoginSessionDto();
		loginSessionDto.setUserId("youniforever");
		loginSessionDto.setUserName("이태성");
		loginSessionDto.setUserAge(32);
		loginSessionDto.setUserDivision(0);
		loginSessionDto.setUserLevel(0);
		
		session.setAttribute("loginSession", loginSessionDto);
	}

	/**
	 * 세션값을 제거
	 * 
	 * @param req
	 * @param key
	 */
	public static void remove(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute(key);
	}

	/**
	 * 세션전체를 무효화
	 * 
	 * @param req
	 */
	public static void removeAll(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
	}
}
