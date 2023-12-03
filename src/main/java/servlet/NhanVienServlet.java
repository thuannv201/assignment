package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CuaHangService;
import service.NhanVienService;

@WebServlet(name = "NhanVienServlet", urlPatterns = "/admin/nhan-vien/*")
public class NhanVienServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private NhanVienService nhanVienService;
    private CuaHangService cuaHangService;

    public NhanVienServlet() {
        super();
        this.nhanVienService = new NhanVienService();
        this.cuaHangService = new CuaHangService();
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
                req.getSession().setAttribute("listRole", this.cuaHangService.findAll());
                req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPut(req, resp);
    }

}
