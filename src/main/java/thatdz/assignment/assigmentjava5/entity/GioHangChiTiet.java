package thatdz.assignment.assigmentjava5.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@Table(name = "GioHangChiTiet")
    @NamedQueries({
        @NamedQuery(
            name="GioHangChiTiet.getGioHangChiTietByGioHang",
            query="SELECT ctgh FROM GioHangChiTiet ctgh WHERE ctgh.gioHang.id =: idgiohang"
        )
    })
public class GioHangChiTiet {
    @EmbeddedId
    GioHangChiTietKey id;
    
    @ManyToOne
    @MapsId("idGioHang")
    @JoinColumn(name = "IdGioHang")
    GioHang gioHang;
    
    @ManyToOne
    @MapsId("idChiTietSP")
    @JoinColumn(name = "IdChiTietSP")
    ChiTietSanPham chiTietSanPham;
    
    @Column(name = "SoLuong")
    public int soLuong;
    @Column(name = "DonGia")
    public double donGia;
    @Column(name = "DonGiaKhiGiam")
    public double donGiaKhiGiam;
    
}
