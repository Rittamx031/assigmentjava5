package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
        existingNhanVien.setMatKhau(NhanVien.getMatKhau());
        existingNhanVien.setIdCV(NhanVien.getIdCV());
        existingNhanVien.setIdGuiBC(NhanVien.getIdGuiBC());
        existingNhanVien.setTrangThai(NhanVien.getTrangThai());
        return repository.save(existingNhanVien);
    }
}
