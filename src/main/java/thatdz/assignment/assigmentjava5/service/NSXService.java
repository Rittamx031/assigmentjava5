package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.NSX;
import thatdz.assignment.assigmentjava5.repository.NSXIRepo;
@Service
public class NSXService {
    @Autowired
    public NSXIRepo repository;
    public NSX saveNSX(NSX nsx) {
        return repository.save(nsx);
    }
    public List<NSX> saveNSXs(List<NSX> nsxs) {
        return repository.saveAll(nsxs);
    }

    public List<NSX> getNSXs() {
        return repository.findAll();
    }

    public NSX getNSXById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteNSX(UUID id) {
        repository.deleteById(id);
        return "NSX removed !! " + id;
    }

    
    public NSX updateNSX(NSX nsx) {
        NSX existingNSX = repository.findById(nsx.getId()).orElse(null);
        existingNSX.setId(nsx.getId());
        existingNSX.setMa(nsx.getMa());
        existingNSX.setTen(nsx.getTen());
        return repository.save(existingNSX);
    }
}
