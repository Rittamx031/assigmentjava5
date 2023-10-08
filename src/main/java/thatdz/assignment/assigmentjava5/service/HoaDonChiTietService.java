package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.entity.HoaDonChiTiet;
import thatdz.assignment.assigmentjava5.entity.HoaDonChiTietKey;
import thatdz.assignment.assigmentjava5.repository.ChiTietSanPhamIRepo;
import thatdz.assignment.assigmentjava5.repository.HoaDonChiTietRepository;
import thatdz.assignment.assigmentjava5.repository.HoaDonIRepo;

@Service
public class HoaDonChiTietService {
  @Autowired
  HoaDonChiTietRepository repository;
  @Autowired
  HoaDonIRepo hoaDonrepository;
  @Autowired
  ChiTietSanPhamIRepo ctsprepository;
  @Autowired
  GioHangChiTietService ghct;

  public List<HoaDonChiTiet> newHoaDon(HoaDon hoaDon) {
    List<HoaDonChiTiet> list = new ArrayList<>();
    List<GioHangChiTiet> listGioHang = ghct.getGioHangChiTietbyKhachHang(hoaDon.getKhachHang().getId());
    for (GioHangChiTiet gioHangChiTiet : listGioHang) {
      HoaDonChiTiet hDonChiTiet = new HoaDonChiTiet();
      hDonChiTiet.setHoaDon(hoaDon);
      hDonChiTiet.setChiTietSanPham(gioHangChiTiet.getChiTietSanPham());
      hDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());
      hDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
      hDonChiTiet.setId(new HoaDonChiTietKey(hoaDon.getId(), gioHangChiTiet.getChiTietSanPham().getId()));
      list.add(hDonChiTiet);
    }
    return repository.saveAll(list);
  }

  public void deleteHoaDonChiTiet(UUID hoaDon, UUID setIdChiTietSP) {
    repository.deleteById(new HoaDonChiTietKey(hoaDon, setIdChiTietSP));
  }

  public double getTotalPrice(HoaDon hoaDon) {
    List<HoaDonChiTiet> hoaDonChiTiets = repository.getHoaDonChiTietByHoaDon(hoaDon.getId());
    return hoaDonChiTiets.stream().mapToDouble(chiTietHoaDon -> chiTietHoaDon.getDonGia()).sum();
  }

  public List<UUID> getListSanPhamInHoaDon(UUID idHoaDon) {
    return repository.getListSanPham(idHoaDon);
  }

  public List<HoaDonChiTiet> getHoaDonChiTiets(HoaDon hoaDon) {
    List<HoaDonChiTiet> hoaDonChiTiets = repository.getHoaDonChiTietByHoaDon(hoaDon.getId());
    for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTiets) {
      System.out.println(hoaDonChiTiet.getChiTietSanPham().getImage());
      System.out.println(hoaDonChiTiet.getChiTietSanPham().getSanPham().getTen());
    }
    return hoaDonChiTiets;
  }
}
