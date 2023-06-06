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

import thatdz.assignment.assigmentjava5.entity.SanPham;
import thatdz.assignment.assigmentjava5.repository.SanPhamIRepo;

@Service
public class SanPhamService {
    @Autowired
    public SanPhamIRepo repository;
    public SanPham saveSanPham(SanPham sanPham) {
        return repository.save(sanPham);
    }
    public List<SanPham> saveSanPhams(List<SanPham> SanPhams) {
        return repository.saveAll(SanPhams);
    }

    public List<SanPham> getSanPhams() {
        return repository.findAll();
    }

    public SanPham getSanPhamById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSanPham(UUID id) {
        repository.deleteById(id);
        return "SanPham removed !! " + id;
    }

    
    public SanPham updateSanPham(SanPham sanPham) {
        SanPham existingSanPham = repository.findById(sanPham.getId()).orElse(null);
        existingSanPham.setId(sanPham.getId());
        existingSanPham.setMa(sanPham.getMa());
        existingSanPham.setTen(sanPham.getTen());
        return repository.save(existingSanPham);
    }
    public List<SanPham> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<SanPham> SanPhams;
        SanPhams = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<SanPham> page = repository.findAll(pageable);
        SanPhams = page.getContent();
        return SanPhams;
    }
    public List<SanPham> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<SanPham> SanPhams;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<SanPham> page = repository.findAll(pageable);
        SanPhams = page.getContent();
        return SanPhams;
    }
    public List<SanPham> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<SanPham> SanPhams;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<SanPham> page = repository.findAll(pageable);
        SanPhams = page.getContent();
        return SanPhams;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<SanPham> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
 