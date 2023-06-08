package thatdz.assignment.assigmentjava5.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.GioHang;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.repository.GioHangIRepo;

@Service
public class GioHangService {
    @Autowired
    public GioHangIRepo repository;
    public GioHang saveGioHang(GioHang gioHang) {
        return repository.save(gioHang);
    }
    public List<GioHang> saveGioHangs(List<GioHang> GioHangs) {
        return repository.saveAll(GioHangs);
    }

    public List<GioHang> getGioHangs() {
        return repository.findAll();
    }

    public GioHang getGioHangById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteGioHang(UUID id) {
        repository.deleteById(id);
        return "GioHang removed !! " + id;
    }
    public GioHang getGioHangByIDKhachHang(UUID idKhachHang){
        return repository.getGioHangbyKhachHang(idKhachHang);
    }
    public GioHang checkGioHang(KhachHang khachHang){
        GioHang giohang = getGioHangByIDKhachHang(khachHang.getId());
        if(giohang==null){
            giohang = new GioHang();
            giohang.setDiaChi(khachHang.getAddress());
            giohang.setNgayTao(LocalDate.now());
            giohang.setTenNguoiNhan(khachHang.getFullName());
            giohang.setSdt(khachHang.getSdt());
        }
        return giohang;
    }

    public GioHang updateGioHang(GioHang gioHang) {
        GioHang existingGioHang = repository.findById(gioHang.getId()).orElse(null);
        existingGioHang.setId(gioHang.getId());
        existingGioHang.setKhachHang(gioHang.getKhachHang());
        existingGioHang.setNhanVien(gioHang.getNhanVien());
        existingGioHang.setMa(gioHang.getMa());
        existingGioHang.setNgayTao(gioHang.getNgayTao());
        existingGioHang.setNgayThanhToan(gioHang.getNgayThanhToan());
        existingGioHang.setTenNguoiNhan(gioHang.getTenNguoiNhan());
        existingGioHang.setDiaChi(gioHang.getDiaChi());
        existingGioHang.setSdt(gioHang.getSdt());
        existingGioHang.setTinhTrang(gioHang.getTinhTrang());
        return repository.save(existingGioHang);
    }
}
