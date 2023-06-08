package thatdz.assignment.assigmentjava5.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;

public interface GioHangChiTietIRepo extends JpaRepository<GioHangChiTiet,GioHangChiTietKey> {
    public List<GioHangChiTiet> getGioHangChiTietByGioHang(@Param("idgiohang") UUID idgiohang);
}
