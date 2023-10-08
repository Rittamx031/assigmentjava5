package thatdz.assignment.assigmentjava5.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import thatdz.assignment.assigmentjava5.entity.HoaDonChiTiet;
import thatdz.assignment.assigmentjava5.entity.HoaDonChiTietKey;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietKey> {
  @Query("SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.id.idHoaDon = :idHoaDon")
  List<HoaDonChiTiet> getHoaDonChiTietByHoaDon(@Param("idHoaDon") UUID id);

  List<UUID> getListSanPham(@Param("idHoaDon") UUID id);
}
