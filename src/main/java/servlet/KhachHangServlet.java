package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.KhachHangService;

@WebServlet(name = "KhachHangServlet", urlPatterns = { "/admin/khach-hang/*" })
public class KhachHangServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    private KhachHangService khachHangService;
    
    public KhachHangServlet() {
    	khachHangService = new KhachHangService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/khach-hang", "");
		switch (uriPath) {
		case "/":
			req.setAttribute("view", "/views/admin/khach-hang/index.jsp");
			req.setAttribute("lkh", this.khachHangService.findAll());
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		case "/detail":
			String id = req.getParameter("id");
			KhachHang kh = khachHangService.getById(UUID.fromString(id));
			req.setAttribute("view", "/views/admin/khach-hang/edit.jsp");
			req.setAttribute("kh", kh);
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		default:
			break;
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/khach-hang", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			KhachHang modelNew = new KhachHang();
			try {
				Map<String, String[]> requestData = req.getParameterMap();
				String ngaySinhStr = null;
				if (requestData.containsKey("ngaySinh")) {
					ngaySinhStr = requestData.get("ngaySinh")[0];
					requestData.remove("ngaySinh");
				}
				BeanUtils.populate(modelNew, requestData);
				modelNew.setNgaySinh(ngaySinhStr);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			khachHangService.create(modelNew);
			resp.sendRedirect("/assignment/admin/khach-hang/");
			break;
		case "/update":
			KhachHang modelUpdate = new KhachHang();
			try {
				Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
				if (requestData.containsKey("id")) {
					requestData.remove("id");
				}
				String ngaySinhStr = null;
				if (requestData.containsKey("ngaySinh")) {
				    ngaySinhStr = requestData.get("ngaySinh")[0];
				    requestData.remove("ngaySinh");
				}
				BeanUtils.populate(modelUpdate, requestData);
				modelUpdate.setNgaySinh(ngaySinhStr);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			KhachHang origin = khachHangService.getById(UUID.fromString(idStr));
			origin.merge(modelUpdate);
			khachHangService.update(origin);
			resp.sendRedirect("/assignment/admin/khach-hang/");
			break;
		case "/delete":
			khachHangService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/khach-hang/");
			break;
		default:
			break;
		}
    }
}
