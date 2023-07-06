package thatdz.assignment.assigmentjava5.service;

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

import thatdz.assignment.assigmentjava5.entity.CuaHang;
import thatdz.assignment.assigmentjava5.repository.CuaHangIRepo;

@Service
public class CuaHangService {
    @Autowired
    public CuaHangIRepo repository;

    public CuaHang saveCuaHang(CuaHang cuaHang) {
        return repository.save(cuaHang);
    }

    public List<CuaHang> searchCuaHangs(String query) {
        return repository.search(query);
    }

    public List<CuaHang> saveCuaHangs(List<CuaHang> CuaHangs) {
        return repository.saveAll(CuaHangs);
    }

    public List<CuaHang> getCuaHangs() {
        return repository.findAll();
    }

    public CuaHang getCuaHangById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCuaHang(UUID id) {
        repository.deleteById(id);
        return "CuaHang removed !! " + id;
    }

    public CuaHang updateCuaHang(CuaHang CuaHang) {
        CuaHang existingCuaHang = repository.findById(CuaHang.getId()).orElse(null);
        existingCuaHang.setId(CuaHang.getId());
        existingCuaHang.setMa(CuaHang.getMa());
        existingCuaHang.setTen(CuaHang.getTen());
        existingCuaHang.setDiaChi(CuaHang.getDiaChi());
        existingCuaHang.setThanhPho(CuaHang.getThanhPho());
        existingCuaHang.setQuocGia(CuaHang.getQuocGia());
        return repository.save(existingCuaHang);
    }

    public CuaHang updateCuaHangByRest(CuaHang cuahang) {
        Optional<CuaHang> cuahangDb = this.repository.findById(cuahang.getId());
        if (cuahangDb.isPresent()) {
            CuaHang chupdate = cuahangDb.get();
            chupdate.setId(cuahang.getId());
            chupdate.setMa(cuahang.getMa());
            chupdate.setTen(cuahang.getTen());
            chupdate.setDiaChi(cuahang.getDiaChi());
            chupdate.setThanhPho(cuahang.getThanhPho());
            chupdate.setQuocGia(cuahang.getQuocGia());
            return chupdate;
        } else {
            System.out.println("not found !!!!");
            return null;
        }
    }

    // sorting and panigation
    public List<CuaHang> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<CuaHang> cuahangs;
        cuahangs = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<CuaHang> page = repository.findAll(pageable);
        cuahangs = page.getContent();
        return cuahangs;
    }

    public List<CuaHang> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<CuaHang> cuahangs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length - 1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<CuaHang> page = repository.findAll(pageable);
        cuahangs = page.getContent();
        return cuahangs;
    }

    public List<CuaHang> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<CuaHang> cuahangs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<CuaHang> page = repository.findAll(pageable);
        cuahangs = page.getContent();
        return cuahangs;
    }

    public int[] getPageNumber(int rowcount) {
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<CuaHang> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb = new int[totalPage];
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i + 1;
        }
        return nb;
    }
}
