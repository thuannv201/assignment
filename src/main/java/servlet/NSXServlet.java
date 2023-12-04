package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NSXService;

@WebServlet(name = "NSXServlet", urlPatterns = "/admin/nsx/*")
public class NSXServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    private NSXService nsxService;
    
    public NSXServlet() {
    	nsxService = new NSXService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/nsx", "");
		switch (uriPath) {
		case "/":
			req.setAttribute("view", "/views/admin/nsx/index.jsp");
			req.setAttribute("lnsx", this.nsxService.findAll());
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		case "/detail":
			String id = req.getParameter("id");
			NSX nsx = nsxService.getById(UUID.fromString(id));
			req.setAttribute("view", "/views/admin/nsx/edit.jsp");
			req.setAttribute("nsx", nsx);
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		default:
			break;
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/nsx", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			NSX modelNew = new NSX();
			try {
				Map<String, String[]> requestData = req.getParameterMap();
				BeanUtils.populate(modelNew, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			nsxService.create(modelNew);
			resp.sendRedirect("/assignment/admin/nsx/");
			break;
		case "/update":
			NSX modelUpdate = new NSX();
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
			NSX origin = nsxService.getById(UUID.fromString(idStr));
			origin.merge(modelUpdate);
			nsxService.update(origin);
			resp.sendRedirect("/assignment/admin/nsx/");
			break;
		case "/delete":
			nsxService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/nsx/");
			break;
		default:
			break;
		}
    }
    
}
