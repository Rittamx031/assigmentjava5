package thatdz.assignment.assigmentjava5.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.repository.ChiTietSanPhamIRepo;

@Service
public class SanPhamOrderService {
  @Autowired
  public ChiTietSanPhamIRepo repository;

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
    Page<ChiTietSanPham> page = repository.search(txt,pageable);
    ChiTietChiTietSanPhams = page.getContent();
    return ChiTietChiTietSanPhams;
  }

  public int getPageNumber(String txt, int rowcount) {
    Pageable pageable = PageRequest.of(1, rowcount);
    Page<ChiTietSanPham> page = repository.search(txt, pageable);
    int totalPage = page.getTotalPages();
    return totalPage;
  }

  public int[] getPanigation(String txt,int rowcount, int pageno) {
    Pageable pageable = PageRequest.of(0, rowcount);
    Page<ChiTietSanPham> page = repository.search(txt,pageable); // findAll()
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
  //  end panigation
  // process hoa don
  
  // end process hoa don
}
