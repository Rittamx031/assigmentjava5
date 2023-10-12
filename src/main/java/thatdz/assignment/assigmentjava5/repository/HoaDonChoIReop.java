package thatdz.assignment.assigmentjava5.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import thatdz.assignment.assigmentjava5.entity.HoaDonCho;

public interface HoaDonChoIReop extends JpaRepository<HoaDonCho, Integer> {
  @Query(value = "SELECT hdc FROM HoaDonCho hdc WHERE hdc.idHoaDon = :idHoaDon")
  Optional<HoaDonCho> getHoaDonChiTietByIDHoaDon(@Param("idHoaDon") UUID idHoaDon);
}
