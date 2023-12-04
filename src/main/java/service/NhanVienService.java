package service;

import java.util.List;
import java.util.UUID;

import entity.NhanVien;
import repositories.NhanVienRepository;

public class NhanVienService {

    private NhanVienRepository nhanVienRepository;
    
    public NhanVienService() {
        this.nhanVienRepository =  new NhanVienRepository();
    }

    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getById(UUID id) {
        return nhanVienRepository.findById(id);
    }

    public void create(NhanVien entity) {
        nhanVienRepository.create(entity);
    }

    public void update(NhanVien entity) {
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
