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

import thatdz.assignment.assigmentjava5.entity.ChucVu;
import thatdz.assignment.assigmentjava5.repository.ChucVuIRepo;

@Service
public class ChucVuService {
    @Autowired
    public ChucVuIRepo repository;
    public ChucVu saveChucVu(ChucVu chucvu) {
        return repository.save(chucvu);
    }
    public List<ChucVu> saveChucVus(List<ChucVu> chucvus) {
        return repository.saveAll(chucvus);
    }

    public List<ChucVu> getChucVus() {
        return repository.findAll();
    }

    public ChucVu getChucVuById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteChucVu(UUID id) {
        repository.deleteById(id);
        return "ChucVu removed !! " + id;
    }

    
    public ChucVu updateChucvu(ChucVu chucvu) {
        ChucVu existingChucvu = repository.findById(chucvu.getId()).orElse(null);
        existingChucvu.setId(chucvu.getId());
        existingChucvu.setMa(chucvu.getMa());
        existingChucvu.setTen(chucvu.getTen());
        return repository.save(existingChucvu);
    }
    public List<ChucVu> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<ChucVu> ChucVus;
        ChucVus = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<ChucVu> page = repository.findAll(pageable);
        ChucVus = page.getContent();
        return ChucVus;
    }
    public List<ChucVu> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<ChucVu> ChucVus;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<ChucVu> page = repository.findAll(pageable);
        ChucVus = page.getContent();
        return ChucVus;
    }
    public List<ChucVu> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<ChucVu> ChucVus;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<ChucVu> page = repository.findAll(pageable);
        ChucVus = page.getContent();
        return ChucVus;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<ChucVu> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
