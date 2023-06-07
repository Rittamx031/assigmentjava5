package thatdz.assignment.assigmentjava5.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import thatdz.assignment.assigmentjava5.entity.KhachHang;

public interface KhacHangIRepo  extends JpaRepository<KhachHang,UUID>{
    KhachHang login(@Param("ma") String ma,@Param("matkhau") String matkhau);
}
