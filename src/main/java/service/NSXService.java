package service;

import java.util.List;
import java.util.UUID;

import entity.NSX;
import repositories.NSXRepository;

public class NSXService {

    private NSXRepository nsxRepository;

    public NSXService() {
        this.nsxRepository = new NSXRepository();
    }

    public List<NSX> findAll() {
        return nsxRepository.findAll();
    }

    public NSX getById(UUID id) {
        return nsxRepository.findById(id);
    }

    public void create(NSX entity) {
        nsxRepository.create(entity);
    }

    public void update(NSX entity) {
        nsxRepository.update(entity);
    }

    public void delete(NSX entity) {
        nsxRepository.delete(entity);
    }

    public void deleteById(UUID id) {
        nsxRepository.deleteById(id);
    }
}
