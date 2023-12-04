package servlet;

import java.io.IOException;

import entity.ChucVu;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ChucVuService;
import service.NhanVienService;
import utils.HashUtil;

@WebServlet(name = "InitServlet", urlPatterns = "/project-init")
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ChucVuService chucVuService;

	private NhanVienService nhanVienService;

	public InitServlet() {
		this.chucVuService = new ChucVuService();
		this.nhanVienService = new NhanVienService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ChucVu cvExist = this.chucVuService.findByMa("ADMIN");
		if (cvExist == null) {
			ChucVu newChuVu = new ChucVu();
			newChuVu.setMa("ADMIN");
			newChuVu.setTen("Admin");
			this.chucVuService.create(newChuVu);
		}

		NhanVien exist = this.nhanVienService.findByMa("ADMIN");
		if (exist == null) {
			NhanVien newNhanVien = new NhanVien();
			ChucVu admin = this.chucVuService.findByMa("ADMIN");
			newNhanVien.setMatKhau(HashUtil.hash("password12345"));
			newNhanVien.setMa("admin");
			newNhanVien.setTen("Admin");
			newNhanVien.setChucVu(admin);
			newNhanVien.setTrangThai(1);
			nhanVienService.create(newNhanVien);
		}

		resp.getWriter().println("Init project successfully!");
	}

}
