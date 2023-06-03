package thatdz.assignment.assigmentjava5.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.CuaHang;
import thatdz.assignment.assigmentjava5.repository.CuaHangIRepo;
@Service
public class CuaHangService{
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
