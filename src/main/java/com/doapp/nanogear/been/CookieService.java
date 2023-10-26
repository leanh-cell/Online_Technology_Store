package com.doapp.nanogear.been;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	public Cookie get(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies)
				if (cookie.getName().equalsIgnoreCase(name))
					return cookie;
		}
		return null;
	}

	public String getValue(String name, String defaultValue) {
		Cookie cookie = get(name);
		if(cookie != null) {
			return cookie.getValue();
		}
		return defaultValue;
	}

	public Cookie add(String name, String value, int days) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(days * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}

	public void remove(String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

}
