package thatdz.assignment.assigmentjava5.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.dto.request.HoaDonRequest;
import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.entity.HoaDonCho;
import thatdz.assignment.assigmentjava5.entity.NhanVien;
import thatdz.assignment.assigmentjava5.repository.ChiTietSanPhamIRepo;
import thatdz.assignment.assigmentjava5.repository.HoaDonChoIReop;
import thatdz.assignment.assigmentjava5.repository.HoaDonIRepo;
import thatdz.assignment.assigmentjava5.repository.NhanVienIRepo;

@Service
public class SanPhamOrderService {
  @Autowired
  public ChiTietSanPhamIRepo repository;
  @Autowired
  public HoaDonIRepo hdrepository;
  @Autowired
  public NhanVienIRepo nvrepository;
  @Autowired
  public HoaDonChoIReop hdcrepository;

  public ChiTietSanPham saveChiTietSanPham(ChiTietSanPham sanPham) {
    return repository.save(sanPham);
  }

  public List<ChiTietSanPham> saveChiTietSanPhams(List<ChiTietSanPham> ChiTietSanPhams) {
    return repository.saveAll(ChiTietSanPhams);
  }

  public List<ChiTietSanPham> getChiTietSanPhams() {
    return repository.findAll();
  }

  public List<ChiTietSanPham> getChiTietSanPhams(String txt, Pageable page) {
    return repository.search(txt, page).getContent();
  }

  // panigation
  public List<ChiTietSanPham> getPageNo(String txt, int pageNo, int pageSize, String sortBy, boolean sortDir) {
    if (pageNo > getPageNumber(txt, pageSize)) {
      System.out.println("bị null rồi má");
      return null;
    }
    List<ChiTietSanPham> ChiTietChiTietSanPhams;
    ChiTietChiTietSanPhams = new ArrayList<>();
    Sort sort;
    if (sortDir) {
      sort = Sort.by(sortBy).ascending();
    } else {
      sort = Sort.by(sortBy).descending();
    }
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
    // findAll method and pass pageable instance
    Page<ChiTietSanPham> page = repository.search(txt, pageable);
    ChiTietChiTietSanPhams = page.getContent();
    return ChiTietChiTietSanPhams;
  }

  public int getPageNumber(String txt, int rowcount) {
    Pageable pageable = PageRequest.of(1, rowcount);
    Page<ChiTietSanPham> page = repository.search(txt, pageable);
    int totalPage = page.getTotalPages();
    return totalPage;
  }

  public int[] getPanigation(String txt, int rowcount, int pageno) {
    Pageable pageable = PageRequest.of(0, rowcount);
    Page<ChiTietSanPham> page = repository.search(txt, pageable); // findAll()
    int totalPage = page.getTotalPages();
    int[] rs;
    if (totalPage <= 1) {
      int[] rs1 = { 1 };
      return rs1;
    } else if (totalPage <= 3) {
      rs = new int[totalPage];
      for (int i = 1; i <= totalPage; i++) {
        rs[i - 1] = i;
      }
      return rs;
    } else {
      rs = new int[3];
      if (pageno <= 2) {
        int[] rs1 = { 1, 2, 3 };
        rs = rs1;
      }
      if (pageno > 2) {
        if (pageno < totalPage - 1) {
          int[] rs1 = { pageno - 1, pageno, pageno + 1 };
          rs = rs1;
        }
        if (pageno >= totalPage - 1) {
          int[] rs1 = { totalPage - 2, totalPage - 1, totalPage };
          rs = rs1;
        }
      }
      return rs;
    }
  }

  // end panigation
  // process hoa don
  public String createHoaDon(UUID idNhanVien, HoaDonRequest request) {
    HoaDon hoaDon = new HoaDon();
    hoaDon.setTenNguoiNhan(request.getTenNguoiNhan());
    hoaDon.setDiaChi(request.getDiaChi());
    hoaDon.setSdt(request.getSdt());
    hoaDon.setNgayTao(LocalDate.now());
    Optional<NhanVien> nhanvienopl = nvrepository.findById(idNhanVien);
    if (nhanvienopl.isPresent()) {
      hoaDon.setNhanVien(nhanvienopl.get());
    } else {
      return "nologin";
    }
    hoaDon.setTinhTrang(0);
    HoaDon hoadonSave = hdrepository.save(hoaDon);
    HoaDonCho hDonCho = new HoaDonCho();
    hDonCho.setIdHoaDon(hoadonSave.getId());
    hDonCho.setIdNguoiTao(hoadonSave.getNhanVien().getId());
    hDonCho.setRoles("EMP");
    hDonCho.setNote("Hóa Đơn: " + hoadonSave.getMa() + " Được tạo ngày:  " + hoadonSave.getNgayTao()
        + "Chưa thành công vui lòng check <3");
    return hoadonSave.getId().toString();
  }

  public UUID thanhToanHoaDon(UUID idHoaDon) {
    Optional<HoaDon> hoaDonOptional = hdrepository.findById(idHoaDon);
    Optional<HoaDonCho> hoaDonchoOptional = hdcrepository.getHoaDonChiTietByIDHoaDon(idHoaDon);
    if (hoaDonOptional.isPresent()) {
      HoaDon hoaDonSave = hoaDonOptional.get();
      hoaDonSave.setNgayThanhToan(LocalDate.now());
      hoaDonSave.setTinhTrang(1);
      if (hoaDonchoOptional.isPresent()) {
        hdcrepository.delete(hoaDonchoOptional.get());
      }
      hdrepository.save(hoaDonSave);
      return hoaDonSave.getId();
    }
    return null;
  }
  // end process hoa don

}
