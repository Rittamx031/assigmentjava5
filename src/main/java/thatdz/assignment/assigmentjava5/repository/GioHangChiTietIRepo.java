package thatdz.assignment.assigmentjava5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;

public interface GioHangChiTietIRepo extends JpaRepository<GioHangChiTiet,GioHangChiTietKey> {
    
}
