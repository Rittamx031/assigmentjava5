package thatdz.assignment.assigmentjava5.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import thatdz.assignment.assigmentjava5.entity.CuaHang;

/**
 * CuaHangIRepo
 */
public interface CuaHangIRepo extends JpaRepository<CuaHang,UUID>{
    List<CuaHang> search(@Param("query") String query);
}