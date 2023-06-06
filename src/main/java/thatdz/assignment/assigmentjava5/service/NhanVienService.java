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

import thatdz.assignment.assigmentjava5.entity.NhanVien;
import thatdz.assignment.assigmentjava5.repository.NhanVienIRepo;

@Service
public class NhanVienService {
    @Autowired
    public NhanVienIRepo repository;
    public NhanVien saveNhanVien(NhanVien NhanVien) {
        return repository.save(NhanVien);
    }

    public List<NhanVien> saveNhanViens(List<NhanVien> NhanViens) {
        return repository.saveAll(NhanViens);
    }

    public List<NhanVien> getNhanViens() {
        return repository.findAll();
    }

    public NhanVien getNhanVienById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteNhanVien(UUID id) {
        repository.deleteById(id);
        return "NhanVien removed !! " + id;
    }

    public NhanVien updateNhanVien(NhanVien NhanVien) {
        NhanVien existingNhanVien = repository.findById(NhanVien.getId()).orElse(null);
        existingNhanVien.setId(NhanVien.getId());
        existingNhanVien.setMa(NhanVien.getMa());
        existingNhanVien.setTen(NhanVien.getTen());
        existingNhanVien.setTenDem(NhanVien.getTenDem());
        existingNhanVien.setHo(NhanVien.getHo());
        existingNhanVien.setGioiTinh(NhanVien.getGioiTinh());
        existingNhanVien.setNgaySinh(NhanVien.getNgaySinh());
        existingNhanVien.setDiaChi(NhanVien.getDiaChi());
        existingNhanVien.setSdt(NhanVien.getSdt());
        existingNhanVien.setChucvu(NhanVien.getChucvu());
        existingNhanVien.setQuanly(NhanVien.getQuanly());
        existingNhanVien.setTrangThai(NhanVien.getTrangThai());
        return repository.save(existingNhanVien);
    }
    public List<NhanVien> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<NhanVien> NhanViens;
        NhanViens = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<NhanVien> page = repository.findAll(pageable);
        NhanViens = page.getContent();
        return NhanViens;
    }
    public List<NhanVien> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<NhanVien> NhanViens;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<NhanVien> page = repository.findAll(pageable);
        NhanViens = page.getContent();
        return NhanViens;
    }
    public List<NhanVien> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<NhanVien> NhanViens;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<NhanVien> page = repository.findAll(pageable);
        NhanViens = page.getContent();
        return NhanViens;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<NhanVien> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
