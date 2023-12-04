package service;

import java.util.List;
import java.util.UUID;

import entity.DongSP;
import repositories.DongSPRepository;

public class DongSPService {
    private DongSPRepository dongSPRepository;

    public DongSPService() {
        this.dongSPRepository = new DongSPRepository();
    }

    public List<DongSP> findAll() {
        return dongSPRepository.findAll();
    }

    public DongSP getById(UUID id) {
        return dongSPRepository.findById(id);
    }

    public void create(DongSP entity) {
        dongSPRepository.create(entity);
    }

    public void update(DongSP entity) {
        dongSPRepository.update(entity);
    }

    public void delete(DongSP entity) {
        dongSPRepository.delete(entity);
    }

    public void deleteById(UUID id) {
        dongSPRepository.deleteById(id);
    }
}
