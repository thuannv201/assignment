package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import entity.ChiTietSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ChiTietSPService;
import service.DongSPService;
import service.MauSacService;
import service.NSXService;
import service.SanPhamService;

@WebServlet(name = "ChiTietSPServlet", urlPatterns = { "/admin/chi-tiet-sp/*" })
public class ChiTietSPServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SanPhamService sanPhamService;
    private NSXService nsxService;
    private ChiTietSPService chiTietSPService;
    private DongSPService dongSPService;
    private MauSacService mauSacService;

    public ChiTietSPServlet() {
        this.sanPhamService = new SanPhamService();
        this.nsxService = new NSXService();
        this.chiTietSPService = new ChiTietSPService();
        this.dongSPService = new DongSPService();
        this.mauSacService = new MauSacService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/chi-tiet-sp", "");
        switch (uriPath) {
            case "/":
                req.setAttribute("view", "/views/admin/chi-tiet-sp/index.jsp");
                req.setAttribute("lsp", this.sanPhamService.findAll());
                req.setAttribute("lnsx", this.nsxService.findAll());
                req.setAttribute("lctsp", this.chiTietSPService.findAll());
                req.setAttribute("ldsp", this.dongSPService.findAll());
                req.setAttribute("lms", this.mauSacService.findAll());
                req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
                break;
            case "/detail":
                String id = req.getParameter("id");
                ChiTietSP ctsp = chiTietSPService.getById(UUID.fromString(id));
                req.setAttribute("view", "/views/admin/chi-tiet-sp/edit.jsp");
                req.setAttribute("ctsp", ctsp);
                req.setAttribute("lsp", this.sanPhamService.findAll());
                req.setAttribute("lnsx", this.nsxService.findAll());
                req.setAttribute("ldsp", this.dongSPService.findAll());
                req.setAttribute("lms", this.mauSacService.findAll());
                req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriPath = req.getRequestURI().replace(req.getContextPath() + "/admin/chi-tiet-sp", "");
        String idStr = req.getParameter("id");
        switch (uriPath) {
            case "/create":
                ChiTietSP modelNew = new ChiTietSP();
                try {
                    Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
                    BeanUtils.populate(modelNew, requestData);
                    if (requestData.containsKey("idSP")) {
    				    modelNew.setIdSp(requestData.get("idSP")[0]);
    				}
                    if (requestData.containsKey("idNsx")) {
    				    modelNew.setIdNsx(requestData.get("idNsx")[0]);
    				}
                    if (requestData.containsKey("idMauSac")) {
    				    modelNew.setIdMauSac(requestData.get("idMauSac")[0]);
    				}
                    if (requestData.containsKey("idDongSP")) {
    				    modelNew.setIdDongSP(requestData.get("idDongSP")[0]);
    				}
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                chiTietSPService.create(modelNew);
                resp.sendRedirect("/assignment/admin/chi-tiet-sp/");
                break;
            case "/update":
            	ChiTietSP origin = chiTietSPService.getById(UUID.fromString(idStr));
            	ChiTietSP update = new ChiTietSP();
                try {
                    Map<String, String[]> requestData = new HashMap<>(req.getParameterMap());
                    if (requestData.containsKey("id")) {
                        requestData.remove("id");
                    }
                    BeanUtils.populate(update, requestData);
                    if (requestData.containsKey("idSP")) {
                    	update.setIdSp(requestData.get("idSP")[0]);
    				}
                    if (requestData.containsKey("idNsx")) {
                    	update.setIdNsx(requestData.get("idNsx")[0]);
    				}
                    if (requestData.containsKey("idMauSac")) {
                    	update.setIdMauSac(requestData.get("idMauSac")[0]);
    				}
                    if (requestData.containsKey("idDongSP")) {
                    	update.setIdDongSP(requestData.get("idDongSP")[0]);
    				}
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                origin.merge(update);
                chiTietSPService.update(origin);
                resp.sendRedirect("/assignment/admin/chi-tiet-sp/");
                break;
            case "/delete":
                chiTietSPService.deleteById(UUID.fromString(idStr));
                resp.sendRedirect("/assignment/admin/chi-tiet-sp/");
                break;
            default:
                break;
        }
    }
}
