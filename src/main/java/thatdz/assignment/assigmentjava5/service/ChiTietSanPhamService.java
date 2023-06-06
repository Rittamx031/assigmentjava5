package thatdz.assignment.assigmentjava5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.repository.ChiTietSanPhamIRepo;

@Service
public class ChiTietSanPhamService {
    @Autowired
    public ChiTietSanPhamIRepo repository;
    public ChiTietSanPham saveChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        return repository.save(chiTietSanPham);
    }
    public List<ChiTietSanPham> saveChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
        return repository.saveAll(chiTietSanPhams);
    }

    public List<ChiTietSanPham> getChiTietSanPhams() {
        return repository.findAll();
    }

    public ChiTietSanPham getChiTietSanPhamById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteChiTietSanPham(UUID id) {
        repository.deleteById(id);
        return "ChiTietSanPham removed !! " + id;
    }

    
    public ChiTietSanPham updateChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham existingChiTietSanPham = repository.findById(chiTietSanPham.getId()).orElse(null);
        existingChiTietSanPham.setId(chiTietSanPham.getId());
        existingChiTietSanPham.setSanPham(chiTietSanPham.getSanPham());
        existingChiTietSanPham.setNsx(chiTietSanPham.getNsx());
        existingChiTietSanPham.setMauSac(chiTietSanPham.getMauSac());
        existingChiTietSanPham.setDongSP(chiTietSanPham.getDongSP());
        existingChiTietSanPham.setNamBH(chiTietSanPham.getNamBH());
        existingChiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon());
        existingChiTietSanPham.setGiaNhap(chiTietSanPham.getGiaNhap());
        existingChiTietSanPham.setGiaBan(chiTietSanPham.getGiaBan());
        return repository.save(existingChiTietSanPham);
    }
    public List<ChiTietSanPham> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<ChiTietSanPham> ChiTietSanPhams;
        ChiTietSanPhams = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<ChiTietSanPham> page = repository.findAll(pageable);
        ChiTietSanPhams = page.getContent();
        return ChiTietSanPhams;
    }
    public List<ChiTietSanPham> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<ChiTietSanPham> ChiTietSanPhams;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<ChiTietSanPham> page = repository.findAll(pageable);
        ChiTietSanPhams = page.getContent();
        return ChiTietSanPhams;
    }
    public List<ChiTietSanPham> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<ChiTietSanPham> ChiTietSanPhams;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<ChiTietSanPham> page = repository.findAll(pageable);
        ChiTietSanPhams = page.getContent();
        return ChiTietSanPhams;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<ChiTietSanPham> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
