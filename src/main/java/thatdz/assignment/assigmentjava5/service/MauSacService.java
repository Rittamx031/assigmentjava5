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

import thatdz.assignment.assigmentjava5.entity.MauSac;
import thatdz.assignment.assigmentjava5.repository.MauSacIRepo;

@Service
public class MauSacService {
    @Autowired
    public MauSacIRepo repository;
    public MauSac saveMauSac(MauSac MauSac) {
        return repository.save(MauSac);
    }
    public List<MauSac> saveMauSacs(List<MauSac> MauSacs) {
        return repository.saveAll(MauSacs);
    }

    public List<MauSac> getMauSacs() {
        return repository.findAll();
    }

    public MauSac getMauSacById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteMauSac(UUID id) {
        repository.deleteById(id);
        return "MauSac removed !! " + id;
    }

    
    public MauSac updateMauSac(MauSac MauSac) {
        MauSac existingMauSac = repository.findById(MauSac.getId()).orElse(null);
        existingMauSac.setId(MauSac.getId());
        existingMauSac.setMa(MauSac.getMa());
        existingMauSac.setTen(MauSac.getTen());
        return repository.save(existingMauSac);
    }
    public List<MauSac> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<MauSac> MauSacs;
        MauSacs = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<MauSac> page = repository.findAll(pageable);
        MauSacs = page.getContent();
        return MauSacs;
    }
    public List<MauSac> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<MauSac> MauSacs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<MauSac> page = repository.findAll(pageable);
        MauSacs = page.getContent();
        return MauSacs;
    }
    public List<MauSac> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<MauSac> MauSacs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<MauSac> page = repository.findAll(pageable);
        MauSacs = page.getContent();
        return MauSacs;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<MauSac> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
