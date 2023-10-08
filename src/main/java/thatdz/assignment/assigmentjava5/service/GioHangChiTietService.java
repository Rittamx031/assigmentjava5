package thatdz.assignment.assigmentjava5.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.dto.request.GioHangViewModel;
import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.GioHang;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
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

    public String checkSanPhamExists(GioHang gioHang, ChiTietSanPham chiTietSanPham) {
        GioHangChiTiet gioHangChiTiet = getGioHangChiTietById(
                new GioHangChiTietKey(gioHang.getId(), chiTietSanPham.getId()));
        if (gioHangChiTiet == null) {
            GioHangChiTiet newGioHangChiTiet = new GioHangChiTiet();
            GioHangChiTietKey gioHangChiTietKey = new GioHangChiTietKey();
            gioHangChiTietKey.setIdGioHang(gioHang.getId());
            gioHangChiTietKey.setIdChiTietSP(chiTietSanPham.getId());
            newGioHangChiTiet.setId(gioHangChiTietKey);
            newGioHangChiTiet.setChiTietSanPham(chiTietSanPham);
            newGioHangChiTiet.setGioHang(gioHang);
            newGioHangChiTiet.setDonGia(chiTietSanPham.getGiaBan());
            newGioHangChiTiet.setDonGiaKhiGiam(0);
            newGioHangChiTiet.setSoLuong(1);
            repository.save(newGioHangChiTiet);
            repository.save(newGioHangChiTiet);
            return "Đã Thêm Thành Công";
        } else {
            return "Sản Phẩm đã Tồn tại";
        }
    }

    public String deleteGioHangChiTiet(GioHangChiTietKey id) {
        repository.deleteById(id);
        return "GioHangChiTiet removed !! " + id;
    }

    public List<GioHangViewModel> getGioHangViewModel(GioHang gioHang) {
        List<GioHangChiTiet> list = repository.getGioHangChiTietByGioHang(gioHang.getId());
        List<GioHangViewModel> listmd = new ArrayList<>();
        for (GioHangChiTiet ghct : list) {
            GioHangViewModel model = new GioHangViewModel();
            model.setId(ghct.getId());
            model.setImage(ghct.getChiTietSanPham().getImage());
            model.setTenSanpham(ghct.getChiTietSanPham().getSanPham().getTen());
            model.setSoLuong(ghct.getSoLuong());
            model.setGia(ghct.getChiTietSanPham().getGiaBan());
            model.setSoLuong(ghct.getSoLuong());
            model.setTong(ghct.getDonGia());
            model.setChecked(true);
            listmd.add(model);
        }
        return listmd;
    }

    public GioHangChiTiet updateQuality(GioHang gioHang, UUID idSanPham, int soLuong) {
        GioHangChiTiet ghct = getGioHangChiTietById(new GioHangChiTietKey(gioHang.getId(), idSanPham));
        ghct.setSoLuong(soLuong);
        ghct.setDonGia(ghct.getSoLuong() * ghct.getChiTietSanPham().getGiaBan());
        return repository.save(ghct);
    }

    public String deleteGioHangChiTiet(GioHang gioHang, UUID idSanPham) {
        repository.deleteById(new GioHangChiTietKey(gioHang.getId(), idSanPham));
        return "GioHangChiTiet removed !! ";
    }

    public List<GioHangChiTiet> getGioHangChiTietbyKhachHang(UUID id) {
        return repository.findAll();
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

    public boolean xoaGioHangChiTiet(List<UUID> listSp, UUID idKhachHang) {
        List<GioHangChiTiet> listremove = repository.getGioHangChiTietByGioHang(idKhachHang).stream()
                .filter((giohangct) -> {
                    return listSp.contains(giohangct.getChiTietSanPham().getId());
                }).collect(Collectors.toList());
        repository.deleteAll(listremove);
        return true;
    }
}
