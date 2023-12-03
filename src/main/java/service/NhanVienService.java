package service;

import java.util.List;

import entity.NhanVien;
import repositories.ChucVuRepository;
import repositories.NhanVienRepository;

public class NhanVienService {

    private NhanVienRepository nhanVienRepository;
    private ChucVuRepository chucVuRepository;
    
    public NhanVienService() {
        this.nhanVienRepository =  new NhanVienRepository();
        this.chucVuRepository = new ChucVuRepository();
    }

    public List<NhanVien> findAll() {
    	chucVuRepository.findAll();
        return null;
    }

}
