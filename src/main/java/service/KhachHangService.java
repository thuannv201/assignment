package service;

import java.util.List;
import java.util.UUID;

import entity.KhachHang;
import repositories.KhachHangRepository;
import utils.HashUtil;

public class KhachHangService {

    private KhachHangRepository khachHangRepository;

    public KhachHangService() {
        this.khachHangRepository = new KhachHangRepository();
    }

    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    public KhachHang getById(UUID id) {
        return khachHangRepository.findById(id);
    }

    public void create(KhachHang entity) {
    	if (entity.getMatKhau() != null) {    		
    		entity.setMatKhau(HashUtil.hash(entity.getMatKhau()));
    	}
        khachHangRepository.create(entity);
    }

    public void update(KhachHang entity) {
    	if (entity.getMatKhau() != null) {    		
    		entity.setMatKhau(HashUtil.hash(entity.getMatKhau()));
    	}
        khachHangRepository.update(entity);
    }

    public void delete(KhachHang entity) {
        khachHangRepository.delete(entity);
    }

    public void deleteById(UUID id) {
        khachHangRepository.deleteById(id);
    }
}
