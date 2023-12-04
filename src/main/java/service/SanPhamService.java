package service;

import java.util.List;
import java.util.UUID;

import entity.SanPham;
import repositories.SanPhamRepository;

public class SanPhamService {
    
    private SanPhamRepository sanPhamRepository;

    public SanPhamService() {
        this.sanPhamRepository = new SanPhamRepository();
    }

    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    public SanPham getById(UUID id) {
        return sanPhamRepository.findById(id);
    }

    public void create(SanPham entity) {
        sanPhamRepository.create(entity);
    }

    public void update(SanPham entity) {
        sanPhamRepository.update(entity);
    }

    public void delete(SanPham entity) {
        sanPhamRepository.delete(entity);
    }

    public void deleteById(UUID id) {
        sanPhamRepository.deleteById(id);
    }
}
