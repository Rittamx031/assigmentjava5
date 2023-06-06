package thatdz.assignment.assigmentjava5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;
import thatdz.assignment.assigmentjava5.repository.GioHangChiTietIRepo;
@Service
public class GioHangChiTietService {
    @Autowired
    public GioHangChiTietIRepo repository;
    public GioHangChiTiet saveGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        return repository.save(gioHangChiTiet);
    }
    public List<GioHangChiTiet> saveGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
        return repository.saveAll(gioHangChiTiets);
    }

    public List<GioHangChiTiet> getGioHangChiTiets() {
        return repository.findAll();
    }

    public GioHangChiTiet getGioHangChiTietById(GioHangChiTietKey id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteGioHangChiTiet(GioHangChiTietKey id) {
        repository.deleteById(id);
        return "GioHangChiTiet removed !! " + id;
    }

    
    public GioHangChiTiet updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        GioHangChiTiet existingGioHangChiTiet = repository.findById(gioHangChiTiet.getId()).orElse(null);
        existingGioHangChiTiet.setId(gioHangChiTiet.getId());
        existingGioHangChiTiet.setDonGia(gioHangChiTiet.getDonGia());
        existingGioHangChiTiet.setDonGiaKhiGiam(gioHangChiTiet.getDonGiaKhiGiam());
        existingGioHangChiTiet.setGioHang(gioHangChiTiet.getGioHang());
        existingGioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
        return repository.save(existingGioHangChiTiet);
    }
    
}
