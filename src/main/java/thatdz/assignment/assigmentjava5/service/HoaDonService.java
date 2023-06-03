package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.repository.HoaDonIRepo;

@Service
public class HoaDonService {
    @Autowired
    public HoaDonIRepo repository;
    public HoaDon saveHoaDon(HoaDon hoaDon) {
        return repository.save(hoaDon);
    }
    public List<HoaDon> saveHoaDons(List<HoaDon> hoaDons) {
        return repository.saveAll(hoaDons);
    }

    public List<HoaDon> getHoaDons() {
        return repository.findAll();
    }

    public HoaDon getHoaDonById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteHoaDon(UUID id) {
        repository.deleteById(id);
        return "HoaDon removed !! " + id;
    }

    
    public HoaDon updateHoaDon(HoaDon hoaDon) {
        HoaDon existingHoaDon = repository.findById(hoaDon.getId()).orElse(null);
        existingHoaDon.setId(hoaDon.getId());
        existingHoaDon.setKhachHang(hoaDon.getKhachHang());
        existingHoaDon.setNhanVien(hoaDon.getNhanVien());
        existingHoaDon.setMa(hoaDon.getMa());
        existingHoaDon.setNgayTao(hoaDon.getNgayTao());
        existingHoaDon.setNgayThanhToan(hoaDon.getNgayThanhToan());
        existingHoaDon.setNgayNhan(hoaDon.getNgayNhan());
        existingHoaDon.setTinhTrang(hoaDon.getTinhTrang());
        existingHoaDon.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
        existingHoaDon.setDiaChi(hoaDon.getDiaChi());
        existingHoaDon.setSdt(hoaDon.getSdt());
        return repository.save(existingHoaDon);
    }
}
