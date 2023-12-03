package service;

import java.util.List;
import java.util.UUID;

import entity.CuaHang;
import repositories.CuaHangRepository;

public class CuaHangService {

	private CuaHangRepository cuaHangRepository;

	public CuaHangService() {
		this.cuaHangRepository = new CuaHangRepository();
	}

	public List<CuaHang> findAll() {
		return cuaHangRepository.findAll();
	}
	
	public CuaHang getById(UUID id) {
		return cuaHangRepository.findById(id);
	}

	public void create(CuaHang cuaHang) {
		cuaHangRepository.create(cuaHang);
	}
	
	public void update(CuaHang cuaHang) {
		cuaHangRepository.update(cuaHang);
	}
	
	public void delete(CuaHang cuaHang) {
		cuaHangRepository.delete(cuaHang);
	}
	
	public void deleteById(UUID id) {
		cuaHangRepository.deleteById(id);
	}
}
