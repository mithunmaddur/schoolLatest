/**
 * 
 */
package com.school.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * << Add Comments Here >>
 *
 * @author
 * @date 06-Jun-2018 4:29:51 PM
 * @version 1.0
 */
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.getSession(true).setAttribute("ENTRY", System.currentTimeMillis());
		logger.info("LoggerInterceptor :: preHandle method", "[Request: ][" + request + "]" + "[" + request.getMethod()
				+ "]" + request.getRequestURI() + getParameters(request));
		return true; 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("LoggerInterceptor :: postHandle method", "[Response][" + request + "]");
	}

	private String getParameters(HttpServletRequest request) {
		StringBuilder posted = new StringBuilder();
		Enumeration<?> e = request.getParameterNames();
		if (e != null) {
			posted.append("?");
			while (e.hasMoreElements()) {
				if (posted.length() > 1) {
					posted.append("&");
				}
				String curr = (String) e.nextElement();
				posted.append(curr + "=");
				if (curr.contains("password") || curr.contains("pass") || curr.contains("pwd")) {
					posted.append("*****");
				} else {
					posted.append(request.getParameter(curr));
				}
			}
		}

		String ip = request.getHeader("X-FORWARDED-FOR");
		String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
		if (ipAddr != null && !ipAddr.equals("")) {
			posted.append("&_psip=" + ipAddr);
		}
		return posted.toString();
	}

	private String getRemoteAddr(HttpServletRequest request) {
		String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
		if (ipFromHeader != null && ipFromHeader.length() > 0) {
			logger.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}
}
