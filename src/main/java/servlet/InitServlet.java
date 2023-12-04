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

@WebServlet(name ="InitServlet", urlPatterns = "/project-init")
public class InitServlet extends HttpServlet{

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
		if (this.chucVuService.checkExist("ADMIN")) {
			ChucVu newChuVu = new ChucVu(null, "ADMIN", "Admin");			
			this.chucVuService.create(newChuVu);
		}
		
		NhanVien newNhanVien = new NhanVien();
		newNhanVien.setMatKhau(HashUtil.hash("password12345"));
		System.out.println(newNhanVien.getMatKhau());
	}

	
}
