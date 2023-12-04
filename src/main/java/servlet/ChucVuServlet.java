package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.ChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ChucVuService;

@WebServlet(name = "ChucVuServlet", urlPatterns = "/admin/chuc-vu/*")
public class ChucVuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ChucVuService chucVuService;

	public ChucVuServlet() {
		this.chucVuService = new ChucVuService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/chuc-vu", "");
		switch (uriPath) {
		case "/":
			req.setAttribute("view", "/views/admin/chuc-vu/index.jsp");
			req.setAttribute("lcv", this.chucVuService.findAll());
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		case "/detail":
			String id = req.getParameter("id");
			ChucVu chucVu = chucVuService.getById(UUID.fromString(id));
			req.setAttribute("view", "/views/admin/chuc-vu/edit.jsp");
			req.setAttribute("cv", chucVu);
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/chuc-vu", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			ChucVu modelNew = new ChucVu();
			try {
				Map<String, String[]> requestData = req.getParameterMap();
				BeanUtils.populate(modelNew, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			chucVuService.create(modelNew);
			resp.sendRedirect("/assignment/admin/chuc-vu/");
			break;
		case "/update":
			ChucVu modelUpdate = new ChucVu();
			try {
				Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
				if (requestData.containsKey("id")) {
					requestData.remove("id");
				}
				BeanUtils.populate(modelUpdate, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			ChucVu origin = chucVuService.getById(UUID.fromString(idStr));
			origin.merge(modelUpdate);
			System.out.println(modelUpdate.getMa());
			chucVuService.update(origin);
			resp.sendRedirect("/assignment/admin/chuc-vu/");
			break;
		case "/delete":
			chucVuService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/chuc-vu/");
			break;
		default:
			break;
		}
	}

}
