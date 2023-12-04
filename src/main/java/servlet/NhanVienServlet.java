package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ChucVuService;
import service.CuaHangService;
import service.NhanVienService;

@WebServlet(name = "NhanVienServlet", urlPatterns = "/admin/nhan-vien/*")
public class NhanVienServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    static {
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
    }

    private NhanVienService nhanVienService;
    private CuaHangService cuaHangService;
    private ChucVuService chucVuService;

    public NhanVienServlet() {
        super();
        this.nhanVienService = new NhanVienService();
        this.cuaHangService = new CuaHangService();
        this.chucVuService = new ChucVuService();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doDelete(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/nhan-vien", "");
        switch (uriPath) {
            case "/":
                req.setAttribute("view", "/views/admin/nhan-vien/index.jsp");
                req.setAttribute("listStaff", this.nhanVienService.findAll());
                req.getSession().setAttribute("listStore", this.cuaHangService.findAll());
                req.getSession().setAttribute("listRole", this.chucVuService.findAll());
                req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/nhan-vien", "");
		String idStr = req.getParameter("id");
		switch (uriPath) {
		case "/create":
			NhanVien modelNew = new NhanVien();
			try {
				Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
				String ngaySinhStr = "";
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
			 nhanVienService.create(modelNew);
			resp.sendRedirect("/assignment/admin/nhan-vien/");
			break;
		case "/update":
			NhanVien modelUpdate = new NhanVien();
			try {
				Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
				if (requestData.containsKey("id")) {
					requestData.remove("id");
				}
				String ngaySinhStr = "";
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
			NhanVien origin = nhanVienService.getById(UUID.fromString(idStr));
			origin.merge(modelUpdate);
			nhanVienService.update(origin);
			resp.sendRedirect("/assignment/admin/nhan-vien/");
			break;
		case "/delete":
			nhanVienService.deleteById(UUID.fromString(idStr));
			resp.sendRedirect("/assignment/admin/nhan-vien/");
			break;
		default:
			break;
		}
    }

}
