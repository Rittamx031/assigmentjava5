package thatdz.assignment.assigmentjava5.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;

public interface ChiTietSanPhamIRepo extends JpaRepository<ChiTietSanPham,UUID> {
    List<ChiTietSanPham>  findByDongSP(UUID dongSPId);
}
