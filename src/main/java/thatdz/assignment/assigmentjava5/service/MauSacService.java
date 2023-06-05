package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.MauSac;
import thatdz.assignment.assigmentjava5.repository.MauSacIRepo;

@Service
public class MauSacService {
    @Autowired
    public MauSacIRepo repository;
    public MauSac saveMauSac(MauSac MauSac) {
        return repository.save(MauSac);
    }
    public List<MauSac> saveMauSacs(List<MauSac> MauSacs) {
        return repository.saveAll(MauSacs);
    }

    public List<MauSac> getMauSacs() {
        return repository.findAll();
    }

    public MauSac getMauSacById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteMauSac(UUID id) {
        repository.deleteById(id);
        return "MauSac removed !! " + id;
    }

    
    public MauSac updateMauSac(MauSac MauSac) {
        MauSac existingMauSac = repository.findById(MauSac.getId()).orElse(null);
        existingMauSac.setId(MauSac.getId());
        existingMauSac.setMa(MauSac.getMa());
        existingMauSac.setTen(MauSac.getTen());
        return repository.save(existingMauSac);
    }
}
