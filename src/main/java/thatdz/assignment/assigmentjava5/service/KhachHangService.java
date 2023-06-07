package thatdz.assignment.assigmentjava5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.entity.Login;
import thatdz.assignment.assigmentjava5.entity.SignUp;
import thatdz.assignment.assigmentjava5.repository.KhacHangIRepo;

@Service
public class KhachHangService {
    @Autowired
    public KhacHangIRepo repository;
    public KhachHang login(Login login){
        return repository.login(login.getMa(), login.getPassword());
    }
    public KhachHang signUp(SignUp signup){
        KhachHang khachHang = new KhachHang();
        khachHang.setHo(signup.getHo());
        khachHang.setTen(signup.getTen());
        khachHang.setTenDem(signup.getTenDem());
        khachHang.setMa(signup.getHo());
        khachHang.setMatKhau(signup.getMatKhau());
        khachHang.setNgaySinh(signup.getNgaySinh());
        khachHang.setDiaChi(signup.getDiaChi());
        khachHang.setQuocGia(signup.getQuocGia());
        khachHang.setThanhPho(signup.getThanhPho());
        return repository.save(khachHang);
    }
}
