package thatdz.assignment.assigmentjava5.entity;

import java.io.Serializable;
import java.util.Objects;
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
    
    @Column(name = "IdChiTietSP")
    UUID idChiTietSP;
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GioHangChiTietKey)) return false;
        GioHangChiTietKey other = (GioHangChiTietKey) obj;
        return Objects.equals(idGioHang, other.idGioHang) && Objects.equals(idChiTietSP, other.idChiTietSP);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idGioHang, idChiTietSP);
    }
    

}
