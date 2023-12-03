package service;

import java.util.List;
import java.util.UUID;

import entity.ChucVu;
import repositories.ChucVuRepository;

public class ChucVuService {
	private ChucVuRepository chucVuRepository;

	public ChucVuService() {
		this.chucVuRepository = new ChucVuRepository();
	}

	public List<ChucVu> findAll() {
		return chucVuRepository.findAll();
	}
	
	public ChucVu getById(UUID id) {
		return chucVuRepository.findById(id);
	}

	public void create(ChucVu entity) {
		chucVuRepository.create(entity);
	}
	
	public void update(ChucVu entity) {
		chucVuRepository.update(entity);
	}
	
	public void delete(ChucVu entity) {
		chucVuRepository.delete(entity);
	}
	
	public void deleteById(UUID id) {
		chucVuRepository.deleteById(id);
	}
}
