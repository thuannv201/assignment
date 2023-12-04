package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MauSacService;

@WebServlet(name = "MauSacServlet", urlPatterns = "/admin/mau-sac/*")
public class MauSacServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MauSacService mauSacService;

    public MauSacServlet() {
        this.mauSacService = new MauSacService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/mau-sac", "");
		switch (uriPath) {
		case "/":
			req.setAttribute("view", "/views/admin/mau-sac/index.jsp");
			req.setAttribute("lms", this.mauSacService.findAll());
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		case "/detail":
			String id = req.getParameter("id");
			MauSac ms = mauSacService.getById(UUID.fromString(id));
			req.setAttribute("view", "/views/admin/mau-sac/edit.jsp");
			req.setAttribute("ms", ms);
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		default:
			break;
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/mau-sac", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			MauSac modelNew = new MauSac();
			try {
				Map<String, String[]> requestData = req.getParameterMap();
				BeanUtils.populate(modelNew, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			mauSacService.create(modelNew);
			resp.sendRedirect("/assignment/admin/mau-sac/");
			break;
		case "/update":
			MauSac modelUpdate = new MauSac();
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
			MauSac origin = mauSacService.getById(UUID.fromString(idStr));
			origin.merge(modelUpdate);
			mauSacService.update(origin);
			resp.sendRedirect("/assignment/admin/mau-sac/");
			break;
		case "/delete":
			mauSacService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/mau-sac/");
			break;
		default:
			break;
		}
    }
}
