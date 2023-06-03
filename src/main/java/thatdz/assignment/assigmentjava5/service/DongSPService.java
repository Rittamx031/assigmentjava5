package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.repository.DongSPIRepo;

@Service
public class DongSPService {
    @Autowired
    public DongSPIRepo repository;
    public DongSP saveDongSP(DongSP dongSP) {
        return repository.save(dongSP);
    }
    public List<DongSP> saveDongSPs(List<DongSP> dongSPs) {
        return repository.saveAll(dongSPs);
    }

    public List<DongSP> getDongSPs() {
        return repository.findAll();
    }

    public DongSP getDongSPById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteDongSP(UUID id) {
        repository.deleteById(id);
        return "DongSP removed !! " + id;
    }

    
    public DongSP updateDongSP(DongSP dongSP) {
        DongSP existingDongSP = repository.findById(dongSP.getId()).orElse(null);
        existingDongSP.setId(dongSP.getId());
        existingDongSP.setMa(dongSP.getMa());
        existingDongSP.setTen(dongSP.getTen());
        return repository.save(existingDongSP);
    }
}
