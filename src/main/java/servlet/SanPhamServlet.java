package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SanPhamService;

@WebServlet(name = "SanPhamServlet", urlPatterns = "/admin/san-pham/*")
public class SanPhamServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

    private SanPhamService sanPhamService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/san-pham", "");
		switch (uriPath) {
		case "/":
			req.setAttribute("view", "/views/admin/san-pham/index.jsp");
			req.setAttribute("stores", this.sanPhamService.findAll());
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
			break;
		case "/detail":
			String id = req.getParameter("id");
			SanPham sp = sanPhamService.getById(UUID.fromString(id));
			req.setAttribute("view", "/views/admin/san-pham/edit.jsp");
			req.setAttribute("sp", sp);
			req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
		default:
			break;
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/san-pham", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			SanPham modelNew = new SanPham();
			try {
				Map<String, String[]> requestData = req.getParameterMap();
				BeanUtils.populate(modelNew, requestData);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			sanPhamService.create(modelNew);
			resp.sendRedirect("/assignment/admin/san-pham/");
			break;
		case "/update":
			SanPham modelUpdate = new SanPham();
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
			SanPham origin = sanPhamService.getById(UUID.fromString(idStr));
			origin.merge(modelUpdate);
			sanPhamService.update(origin);
			resp.sendRedirect("/assignment/admin/san-pham/");
			break;
		case "/delete":
			sanPhamService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/san-pham/");
			break;
		default:
			break;
		}
    }

}
