package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtils {
	// get lấy gtri cookie
	// pp get tìm kiếm thông tin của cookie , if(cookie.getName().equals(name)) so sánh tên của cookie == tên truyền vào thì trả về giá trị cookie 
	public static String get(String name, HttpServletRequest request) {
		Cookie[] cookies =request.getCookies();
		
		if(cookies !=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					return cookie.getValue();
					
				}
			}
		}
		return null;
	}
	// add lưu cookie
	public static Cookie add(String name, String value, int hours, HttpServletResponse reponse) {
		Cookie cookie= new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * hours);
		cookie.setPath("/");
		reponse.addCookie(cookie);
		
		return cookie;
	}
}
