package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.repository.ChiTietSanPhamIRepo;

@Service
public class ChiTietSanPhamService {
    @Autowired
    public ChiTietSanPhamIRepo repository;
    public ChiTietSanPham saveChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        return repository.save(chiTietSanPham);
    }
    public List<ChiTietSanPham> saveChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
        return repository.saveAll(chiTietSanPhams);
    }

    public List<ChiTietSanPham> getChiTietSanPhams() {
        return repository.findAll();
    }

    public ChiTietSanPham getChiTietSanPhamById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteChiTietSanPham(UUID id) {
        repository.deleteById(id);
        return "ChiTietSanPham removed !! " + id;
    }

    
    public ChiTietSanPham updateChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham existingChiTietSanPham = repository.findById(chiTietSanPham.getId()).orElse(null);
        existingChiTietSanPham.setId(chiTietSanPham.getId());
        existingChiTietSanPham.setSanPham(chiTietSanPham.getSanPham());
        existingChiTietSanPham.setNsx(chiTietSanPham.getNsx());
        existingChiTietSanPham.setMauSac(chiTietSanPham.getMauSac());
        existingChiTietSanPham.setDongSP(chiTietSanPham.getDongSP());
        existingChiTietSanPham.setNamBH(chiTietSanPham.getNamBH());
        existingChiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon());
        existingChiTietSanPham.setGiaNhap(chiTietSanPham.getGiaNhap());
        existingChiTietSanPham.setGiaBan(chiTietSanPham.getGiaBan());
        return repository.save(existingChiTietSanPham);
    }
}
