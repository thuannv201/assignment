package servlet;

import java.io.IOException;

import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repositories.NhanVienRepository;
import utils.CookieUtils;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NhanVienRepository nhanVienRepository;

	public LoginController() {
		super();
		this.nhanVienRepository = new NhanVienRepository();
	}

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username", CookieUtils.get("username", request));
		request.setAttribute("view", "/views/auth/login.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma = request.getParameter("ma");
		String password = request.getParameter("password");
		String rm = request.getParameter("chkremeber");
		NhanVien entity = this.nhanVienRepository.login(ma, password);

		if (ma.equals("") && password.equals("")) {
			String error = "Sai mã hoặc mật khẩu";
			request.getSession().setAttribute("error", error);
		} else {
			if (entity == null) {
				String error = "Sai mã hoặc mật khẩu";
				request.getSession().setAttribute("error", error);
				String location = request.getContextPath() + "/login";
				response.sendRedirect(location);
			} else {
				if (rm != null) {
					HttpSession session = request.getSession();
					session.setAttribute("user", entity);
					CookieUtils.add("username", ma, 10, response);
					CookieUtils.add("password", password, 10, response);
					response.sendRedirect(request.getContextPath() + "/admin/cua-hang/");
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("user", entity);
					CookieUtils.add("username", ma, 0, response);
					CookieUtils.add("password", password, 0, response);
					response.sendRedirect(request.getContextPath() + "/admin/cua-hang/");
				}
			}
		}
	}

}
