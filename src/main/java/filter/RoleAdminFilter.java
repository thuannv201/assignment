package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    private final List<String> staffUrls = Arrays.asList("/admin/cua-hang/", "/admin/nhan-vien/", "/admin/khach-hang/",
            "/admin/san-pham/", "/admin/hoa-don/", "/admin/thong-ke/");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        NhanVien user = (NhanVien) session.getAttribute("user");
        if (user.getChucVu().getMa().equals("ADMIN") || (user.getChucVu().getMa().equals("NVBH") && staffUrls
                .contains(servletRequest.getRequestURI().replace(servletRequest.getContextPath(), "")))) {
            filterChain.doFilter(request, response);
        } else {
            servletResponse.sendRedirect(servletRequest.getContextPath() + "/login");
        }
    }

}
