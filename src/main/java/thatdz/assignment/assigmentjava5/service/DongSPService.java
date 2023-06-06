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

import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.repository.DongSPIRepo;

@Service
public class DongSPService {
    @Autowired
    public DongSPIRepo repository;
    public DongSP saveDongSP(DongSP dongSP) {
        return repository.save(dongSP);
    }
    public List<DongSP> saveDongSPs(List<DongSP> dongSPs) {
        return repository.saveAll(dongSPs);
    }

    public List<DongSP> getDongSPs() {
        return repository.findAll();
    }

    public DongSP getDongSPById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteDongSP(UUID id) {
        repository.deleteById(id);
        return "DongSP removed !! " + id;
    }

    
    public DongSP updateDongSP(DongSP dongSP) {
        DongSP existingDongSP = repository.findById(dongSP.getId()).orElse(null);
        existingDongSP.setId(dongSP.getId());
        existingDongSP.setMa(dongSP.getMa());
        existingDongSP.setTen(dongSP.getTen());
        return repository.save(existingDongSP);
    }
    public List<DongSP> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<DongSP> DongSPs;
        DongSPs = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<DongSP> page = repository.findAll(pageable);
        DongSPs = page.getContent();
        return DongSPs;
    }
    public List<DongSP> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<DongSP> DongSPs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<DongSP> page = repository.findAll(pageable);
        DongSPs = page.getContent();
        return DongSPs;
    }
    public List<DongSP> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<DongSP> DongSPs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<DongSP> page = repository.findAll(pageable);
        DongSPs = page.getContent();
        return DongSPs;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<DongSP> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
