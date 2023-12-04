package service;

import java.util.List;
import java.util.UUID;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;
import utils.HashUtil;

public class NhanVienService {

	private NhanVienRepository nhanVienRepository;
	private CuaHangRepository cuaHangRepository;
	private ChucVuRepository chucVuRepository;

	public NhanVienService() {
		this.nhanVienRepository = new NhanVienRepository();
		this.cuaHangRepository = new CuaHangRepository();
		this.chucVuRepository = new ChucVuRepository();
	}

	public List<NhanVien> findAll() {
		return nhanVienRepository.findAll();
	}

	public NhanVien getById(UUID id) {
		return nhanVienRepository.findById(id);
	}

	public void create(NhanVien entity) {
		if (entity.getCuaHang() != null && entity.getCuaHang().getId() != null) {
			CuaHang cuaHang = cuaHangRepository.findById(entity.getCuaHang().getId());
			entity.setCuaHang(cuaHang);
		}
		if (entity.getChucVu() != null && entity.getChucVu().getId() != null) {
			ChucVu chucVu = chucVuRepository.findById(entity.getChucVu().getId());
			entity.setChucVu(chucVu);
		}
		if (entity.getMatKhau() != null) {    		
    		entity.setMatKhau(HashUtil.hash(entity.getMatKhau()));
    	}
		nhanVienRepository.create(entity);
	}

	public void update(NhanVien entity) {
		if (entity.getCuaHang() != null && entity.getCuaHang().getId() != null) {
			CuaHang cuaHang = cuaHangRepository.findById(entity.getCuaHang().getId());
			entity.setCuaHang(cuaHang);
		}
		if (entity.getChucVu() != null && entity.getChucVu().getId() != null) {
			ChucVu chucVu = chucVuRepository.findById(entity.getChucVu().getId());
			entity.setChucVu(chucVu);
		}
		if (entity.getMatKhau() != null) {    		
    		entity.setMatKhau(HashUtil.hash(entity.getMatKhau()));
    	}
		nhanVienRepository.update(entity);
	}

	public void delete(NhanVien entity) {
		nhanVienRepository.delete(entity);
	}

	public void deleteById(UUID id) {
		nhanVienRepository.deleteById(id);
	}

	public NhanVien findByMa(String ma) {
		return nhanVienRepository.findByMa(ma);
	}

}
