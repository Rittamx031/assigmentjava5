package thatdz.assignment.assigmentjava5.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.repository.HoaDonIRepo;
import thatdz.assignment.assigmentjava5.repository.KhacHangIRepo;

@Service
public class HoaDonService {
    @Autowired
    public HoaDonIRepo repository;
    @Autowired
    public KhacHangIRepo khacHangrepository;
    @Autowired
    public GioHangChiTietService gioHangChiTietService;

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
    public HoaDon thanhToan(UUID idHoaDon) {
        Optional<HoaDon> hoadonop = repository.findById(idHoaDon);
        if(hoadonop.isPresent()){
            HoaDon hoaDon = hoadonop.get();
            hoaDon.setTinhTrang(1);
            hoaDon.setNgayThanhToan(LocalDate.now());
        }
        return repository.save(null);
    }

    public HoaDon createHoaDone(UUID idKhachHang) {
        HoaDon hoaDon = new HoaDon();
        Optional<KhachHang> khachHang = khacHangrepository.findById(idKhachHang);
        if (khachHang.isPresent()) {
            KhachHang kh = khachHang.get();
            hoaDon.setKhachHang(kh);
            hoaDon.setTenNguoiNhan(kh.getFullName());
            hoaDon.setDiaChi(kh.getDiaChi());
            hoaDon.setSdt(kh.getSdt());
            hoaDon.setNgayTao(LocalDate.now());
            hoaDon.setTinhTrang(0);
            hoaDon.setNgayNhan(LocalDate.now());
            return repository.save(hoaDon);
        } else {
            return null;
        }
    }
}
