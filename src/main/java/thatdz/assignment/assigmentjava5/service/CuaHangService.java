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

import thatdz.assignment.assigmentjava5.entity.CuaHang;
import thatdz.assignment.assigmentjava5.repository.CuaHangIRepo;

@Service
public class CuaHangService {
    @Autowired
    public CuaHangIRepo repository;

    public CuaHang saveCuaHang(CuaHang cuaHang) {
        return repository.save(cuaHang);
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

    public List<CuaHang> getNextPage(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<CuaHang> products;
        products = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<CuaHang> page = repository.findAll(pageable);
        products = page.getContent();
        return products;
    }
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<CuaHang> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
    public void TestPagination() {
        String sortBy = "ten";
        String sortDir = "asc";
        int pageNo = 1;
        int pageSize = 5;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        // findAll method and pass pageable instance
        Page<CuaHang> page = repository.findAll(pageable);

        List<CuaHang> products = page.getContent();

        products.forEach((p) -> {
            System.out.println(p.toString());
        });

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();
        System.out.println("total page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("numberOfElements -> " + numberOfElements);
        System.out.println(" size ->" + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println(" isFirst -> " + isFirst);
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
}
