package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.ChucVu;
import thatdz.assignment.assigmentjava5.repository.ChucVuIRepo;

@Service
public class ChucVuService {
    @Autowired
    public ChucVuIRepo repository;
    public ChucVu saveChucVu(ChucVu chucvu) {
        return repository.save(chucvu);
    }
    public List<ChucVu> saveChucVus(List<ChucVu> chucvus) {
        return repository.saveAll(chucvus);
    }

    public List<ChucVu> getChucVus() {
        return repository.findAll();
    }

    public ChucVu getChucVuById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteChucVu(UUID id) {
        repository.deleteById(id);
        return "ChucVu removed !! " + id;
    }

    
    public ChucVu updateChucvu(ChucVu chucvu) {
        ChucVu existingChucvu = repository.findById(chucvu.getId()).orElse(null);
        existingChucvu.setId(chucvu.getId());
        existingChucvu.setMa(chucvu.getMa());
        existingChucvu.setTen(chucvu.getTen());
        return repository.save(existingChucvu);
    }
}
