package thatdz.assignment.assigmentjava5.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.assignment.assigmentjava5.entity.GioHang;

public interface GioHangIRepo extends JpaRepository<GioHang,UUID>{
}
