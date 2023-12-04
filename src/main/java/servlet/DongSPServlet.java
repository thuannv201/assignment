package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.DongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DongSPService;

@WebServlet(name = "DongSPServlet", urlPatterns = "/admin/dong-sp/*")
public class DongSPServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DongSPService dongSPService;

	public DongSPServlet() {
		dongSPService = new DongSPService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/dong-sp", "");
		switch (uriPath) {
			case "/":
				req.setAttribute("view", "/views/admin/dongsp/index.jsp");
				req.setAttribute("ldsp", this.dongSPService.findAll());
				req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
				break;
			case "/detail":
				String id = req.getParameter("id");
				DongSP dongSp = dongSPService.getById(UUID.fromString(id));
				req.setAttribute("view", "/views/admin/dongsp/edit.jsp");
				req.setAttribute("dongSp", dongSp);
				req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/dong-sp", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
			case "/create":
				DongSP modelNew = new DongSP();
				try {
					Map<String, String[]> requestData = req.getParameterMap();
					BeanUtils.populate(modelNew, requestData);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				}
				dongSPService.create(modelNew);
				resp.sendRedirect("/assignment/admin/dong-sp/");
				break;
			case "/update":
				DongSP modelUpdate = new DongSP();
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
				DongSP origin = dongSPService.getById(UUID.fromString(idStr));
				origin.merge(modelUpdate);
				dongSPService.update(origin);
				resp.sendRedirect("/assignment/admin/dong-sp/");
				break;
			case "/delete":
				dongSPService.deleteById(UUID.fromString(idStr));
				resp.sendRedirect("/assignment/admin/dong-sp/");
				break;
			default:
				break;
		}
	}
}
