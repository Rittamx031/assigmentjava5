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

import thatdz.assignment.assigmentjava5.entity.NSX;
import thatdz.assignment.assigmentjava5.repository.NSXIRepo;
@Service
public class NSXService {
    @Autowired
    public NSXIRepo repository;
    public NSX saveNSX(NSX nsx) {
        return repository.save(nsx);
    }
    public List<NSX> saveNSXs(List<NSX> nsxs) {
        return repository.saveAll(nsxs);
    }

    public List<NSX> getNSXs() {
        return repository.findAll();
    }

    public NSX getNSXById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteNSX(UUID id) {
        repository.deleteById(id);
        return "NSX removed !! " + id;
    }

    
    public NSX updateNSX(NSX nsx) {
        NSX existingNSX = repository.findById(nsx.getId()).orElse(null);
        existingNSX.setId(nsx.getId());
        existingNSX.setMa(nsx.getMa());
        existingNSX.setTen(nsx.getTen());
        return repository.save(existingNSX);
    }
    public List<NSX> getFirstPage(int pageSize, String sortBy, String sortDir) {
        List<NSX> NSXs;
        NSXs = new ArrayList<>();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(0, pageSize, sort);
        // findAll method and pass pageable instance
        Page<NSX> page = repository.findAll(pageable);
        NSXs = page.getContent();
        return NSXs;
    }
    public List<NSX> getLastPage(int pageSize, String sortBy, String sortDir) {
        List<NSX> NSXs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(getPageNumber(pageSize).length-1, pageSize, sort);
        // findAll method and pass pageable instance
        Page<NSX> page = repository.findAll(pageable);
        NSXs = page.getContent();
        return NSXs;
    }
    public List<NSX> getPageNo(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<NSX> NSXs;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // findAll method and pass pageable instance
        Page<NSX> page = repository.findAll(pageable);
        NSXs = page.getContent();
        return NSXs;
    }
   
    public int[] getPageNumber(int rowcount){
        Pageable pageable = PageRequest.of(1, rowcount);
        Page<NSX> page = repository.findAll(pageable);
        int totalPage = page.getTotalPages();
        int[] nb= new int[totalPage] ;
        for (int i = 0; i < totalPage; i++) {
            nb[i] = i+1;
        }
        return nb;
    }
}
