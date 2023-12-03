package filter;

import java.io.IOException;

import entity.NhanVien;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpSession session = servletRequest.getSession();
		NhanVien user = (NhanVien) session.getAttribute("user");
		if (user == null) {
			String location = servletRequest.getContextPath() + "/login";
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.sendRedirect(location);
		} else {
			chain.doFilter(request, response);
		}
		
	}
    
}
