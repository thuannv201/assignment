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

@WebFilter(urlPatterns = { "/admin/*" })
public class RoleAdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        NhanVien user = (NhanVien) session.getAttribute("user");
        if (user.getChucVu().getMa() != "ADMIN") {
            servletResponse.sendRedirect(servletRequest.getContextPath() + "/login");
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
