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

import thatdz.assignment.assigmentjava5.dto.response.OrderDetail;
import thatdz.assignment.assigmentjava5.dto.response.ProductDetail;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.repository.HoaDonChiTietRepository;
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
  @Autowired
  public HoaDonChiTietRepository hoaDonChiTietRepository;

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

  public OrderDetail getOrderDetail(UUID idHoaDon) {
    Optional<HoaDon> hoadonOp = repository.findById(idHoaDon);
    if (hoadonOp.isPresent()) {
      OrderDetail orderDetail = new OrderDetail();
      List<ProductDetail> listproduct = hoaDonChiTietRepository.getProductDetail(idHoaDon);
      orderDetail.setListhdct(listproduct);
      HoaDon hoaDon = hoadonOp.get();
      orderDetail.setTotalPrice(
          hoaDonChiTietRepository.getHoaDonChiTietByHoaDon(hoaDon.getId()).stream()
              .mapToDouble(chiTietHoaDon -> chiTietHoaDon.getDonGia()).sum());
      orderDetail.setPhoneNumber(hoaDon.getSdt());
      orderDetail.setAddress(hoaDon.getDiaChi());
      orderDetail.setName(hoaDon.getTenNguoiNhan());
      orderDetail.setNgayTao(hoaDon.getNgayTao());
      orderDetail.setNgayThanhToan(hoaDon.getNgayThanhToan());
      return orderDetail;
    }
    return null;
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
    if (hoadonop.isPresent()) {
      HoaDon hoaDon = hoadonop.get();
      hoaDon.setTinhTrang(1);
      hoaDon.setNgayThanhToan(LocalDate.now());
      return repository.save(hoaDon);
    }
    return null;
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

  public List<HoaDon> getPageNo(int pageNo, int pageSize, String sortBy, boolean sortDir) {
    if (pageNo > getPageNumber(pageSize)) {
      System.out.println("bị null rồi má");
      return null;
    }
    List<HoaDon> ChiTietSanPhams;
    ChiTietSanPhams = new ArrayList<>();
    Sort sort;
    if (sortDir) {
      sort = Sort.by(sortBy).ascending();
    } else {
      sort = Sort.by(sortBy).descending();
    }
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
    // findAll method and pass pageable instance
    Page<HoaDon> page = repository.findAll(pageable);
    ChiTietSanPhams = page.getContent();
    ChiTietSanPhams.forEach(ctst -> {
      System.out.println(ctst.getMa());
    });
    return ChiTietSanPhams;
  }

  public int getPageNumber(int rowcount) {
    Pageable pageable = PageRequest.of(1, rowcount);
    Page<HoaDon> page = repository.findAll(pageable);
    int totalPage = page.getTotalPages();
    return totalPage;
  }

  public int[] getPanigation(int rowcount, int pageno) {
    Pageable pageable = PageRequest.of(0, rowcount);
    Page<HoaDon> page = repository.findAll(pageable); // findAll()
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
}
