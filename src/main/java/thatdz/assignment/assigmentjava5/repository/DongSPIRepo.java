package thatdz.assignment.assigmentjava5.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.assignment.assigmentjava5.entity.DongSP;

public interface DongSPIRepo extends JpaRepository<DongSP,UUID> {
    
}
