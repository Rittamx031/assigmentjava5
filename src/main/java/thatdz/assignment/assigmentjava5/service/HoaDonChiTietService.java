package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.GioHang;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;
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

  public void deleteHoaDonChiTiet(UUID hoaDon, UUID idCTSP) {
    repository.deleteById(new HoaDonChiTietKey(hoaDon, idCTSP));
  }

  public HoaDonChiTiet addSanPhamInHoaDon(UUID hoaDon, UUID idCTSP) {
    Optional<ChiTietSanPham> ctsOptional = ctsprepository.findById(idCTSP);
    Optional<HoaDon> hdOptional = hoaDonrepository.findById(hoaDon);
    Optional<HoaDonChiTiet> hdctopl  =repository.findById(new HoaDonChiTietKey(hdOptional.get().getId(), ctsOptional.get().getId())); 
    HoaDonChiTiet hdct = new HoaDonChiTiet();
    if (hdOptional.isPresent()) {
      hdct.setHoaDon(hdOptional.get());
      if (ctsOptional.isPresent()) {
        if (hdctopl.isPresent()) {
          hdct = hdctopl.get();
          hdct.setSoLuong(hdctopl.get().getSoLuong() +1 );
          hdct.setDonGia(ctsOptional.get().getGiaBan() *(hdctopl.get().getSoLuong() +1));
          return repository.save(hdct);
        }
        hdct.setId(new HoaDonChiTietKey(hdOptional.get().getId(), ctsOptional.get().getId()));
        hdct.setChiTietSanPham(ctsOptional.get());
        hdct.setSoLuong(1);
        hdct.setDonGia(ctsOptional.get().getGiaBan());
        return repository.save(hdct);
      } else {
        return null;
      }
    } else {
      return null;
    }
  }

  // public GioHangChiTiet updateQuality(GioHang gioHang, UUID idSanPham, int
  // soLuong) {
  // GioHangChiTiet ghct = getGioHangChiTietById(new
  // GioHangChiTietKey(gioHang.getId(), idSanPham));
  // ghct.setSoLuong(soLuong);
  // ghct.setDonGia(ghct.getSoLuong() * ghct.getChiTietSanPham().getGiaBan());
  // return repository.save(ghct);
  // }
  public HoaDonChiTiet updateSanPhamInHoaDon(int quantity, UUID hoaDon, UUID idCTSP) {
    Optional<HoaDonChiTiet> hoadonChitiet = repository.findById(new HoaDonChiTietKey(hoaDon, idCTSP));
    if (hoadonChitiet.isPresent()) {
      HoaDonChiTiet hdct = hoadonChitiet.get();
      hdct.setSoLuong(quantity);
      hdct.setDonGia(hdct.getChiTietSanPham().getGiaBan() * quantity);
      return repository.save(hdct);
    } else {
      return null;
    }
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
    return hoaDonChiTiets;
  }
}
