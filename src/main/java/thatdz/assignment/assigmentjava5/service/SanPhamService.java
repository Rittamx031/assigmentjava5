package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.SanPham;
import thatdz.assignment.assigmentjava5.repository.SanPhamIRepo;

@Service
public class SanPhamService {
    @Autowired
    public SanPhamIRepo repository;
    public SanPham saveSanPham(SanPham sanPham) {
        return repository.save(sanPham);
    }
    public List<SanPham> saveSanPhams(List<SanPham> SanPhams) {
        return repository.saveAll(SanPhams);
    }

    public List<SanPham> getSanPhams() {
        return repository.findAll();
    }

    public SanPham getSanPhamById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSanPham(UUID id) {
        repository.deleteById(id);
        return "SanPham removed !! " + id;
    }

    
    public SanPham updateSanPham(SanPham sanPham) {
        SanPham existingSanPham = repository.findById(sanPham.getId()).orElse(null);
        existingSanPham.setId(sanPham.getId());
        existingSanPham.setMa(sanPham.getMa());
        existingSanPham.setTen(sanPham.getTen());
        return repository.save(existingSanPham);
    }
}
 