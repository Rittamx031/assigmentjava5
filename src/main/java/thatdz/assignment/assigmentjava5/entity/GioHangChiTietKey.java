package thatdz.assignment.assigmentjava5.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GioHangChiTietKey implements Serializable {

    @Column(name = "IdGioHang")
    UUID idGioHang;

    @Column(name = "IdChiTietSanPham")
    UUID idChiTietSanPham;
    @Override
    public int hashCode() {
        
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
