package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CuaHangService;

@WebServlet(name = "CuaHangServlet", urlPatterns = "/admin/cua-hang/*")
public class CuaHangServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CuaHangService cuaHangService;

	public CuaHangServlet() {
		super();
		this.cuaHangService = new CuaHangService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/cua-hang", "");
		switch (uriPath) {
		case "/":
			req.setAttribute("view", "/views/admin/cua-hang/index.jsp");
			req.setAttribute("stores", this.cuaHangService.findAll());
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		case "/detail":
			String id = req.getParameter("id");
			CuaHang cuaHang = cuaHangService.getById(UUID.fromString(id));
			req.setAttribute("view", "/views/admin/cua-hang/edit.jsp");
			req.setAttribute("store", cuaHang);
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/cua-hang", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			CuaHang cuaHangModel = new CuaHang();
			try {
				Map<String, String[]> requestData = req.getParameterMap();
				BeanUtils.populate(cuaHangModel, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			cuaHangService.create(cuaHangModel);
			resp.sendRedirect("/assignment/admin/cua-hang/");
			break;
		case "/update":
			CuaHang cuaHangUpdate = new CuaHang();
			try {
				Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
				if (requestData.containsKey("id")) {
					requestData.remove("id");
				}
				BeanUtils.populate(cuaHangUpdate, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			CuaHang origin = cuaHangService.getById(UUID.fromString(idStr));
			origin.merge(cuaHangUpdate);
			cuaHangService.update(origin);
			resp.sendRedirect("/assignment/admin/cua-hang/");
			break;
		case "/delete":
			cuaHangService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/cua-hang/");
			break;
		default:
			break;
		}
	}

}
