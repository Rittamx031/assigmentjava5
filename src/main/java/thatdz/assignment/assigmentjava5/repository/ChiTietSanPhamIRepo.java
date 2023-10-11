package thatdz.assignment.assigmentjava5.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;

public interface ChiTietSanPhamIRepo extends JpaRepository<ChiTietSanPham, UUID> {
    List<ChiTietSanPham> findByDongSP(UUID dongSPId);

    @Query("SELECT cts FROM ChiTietSanPham cts WHERE " +
            "(cts.sanPham.ten LIKE CONCAT('%', :searchString, '%') " +
            "OR cts.dongSP.ten LIKE CONCAT('%', :searchString, '%') " +
            "OR cts.mauSac.ten LIKE CONCAT('%', :searchString, '%') " +
            "OR cts.nsx.ten LIKE CONCAT('%', :searchString, '%'))")
    Page<ChiTietSanPham> search(@Param("searchString") String txt, Pageable pageable);

}
