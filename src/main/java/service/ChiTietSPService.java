package service;

import java.util.List;
import java.util.UUID;

import entity.ChiTietSP;
import repositories.ChiTietSPRepository;

public class ChiTietSPService {
    private ChiTietSPRepository chiTietSPRepository;

	public ChiTietSPService() {
		this.chiTietSPRepository = new ChiTietSPRepository();
	}

	public List<ChiTietSP> findAll() {
		return chiTietSPRepository.findAll();
	}
	
	public ChiTietSP getById(UUID id) {
		return chiTietSPRepository.findById(id);
	}

	public void create(ChiTietSP entity) {
		chiTietSPRepository.create(entity);
	}
	
	public void update(ChiTietSP entity) {
		chiTietSPRepository.update(entity);
	}
	
	public void delete(ChiTietSP entity) {
		chiTietSPRepository.delete(entity);
	}
	
	public void deleteById(UUID id) {
		chiTietSPRepository.deleteById(id);
	}
}
