package service;

import java.util.List;
import java.util.UUID;

import entity.MauSac;
import repositories.MauSacRepository;

public class MauSacService {
    
    private MauSacRepository mauSacRepository;

    public MauSacService() {
        mauSacRepository = new MauSacRepository();
    }

    public List<MauSac> findAll() {
        return mauSacRepository.findAll();
    }

    public MauSac getById(UUID id) {
        return mauSacRepository.findById(id);
    }

    public void create(MauSac entity) {
        mauSacRepository.create(entity);
    }

    public void update(MauSac entity) {
        mauSacRepository.update(entity);
    }

    public void delete(MauSac entity) {
        mauSacRepository.delete(entity);
    }

    public void deleteById(UUID id) {
        mauSacRepository.deleteById(id);
    }
}
