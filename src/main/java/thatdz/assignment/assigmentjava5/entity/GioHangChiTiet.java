package thatdz.assignment.assigmentjava5.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
public class GioHangChiTiet {
    @EmbeddedId
    GioHangChiTietKey id;

    @ManyToOne
    @MapsId("idGioHang")
    @JoinColumn(name = "IdGioHang")
    GioHang gioHang;

    @ManyToOne
    @MapsId("idChiTietSanPham")
    @JoinColumn(name = "IdChiTietSP")
    ChiTietSanPham chiTietSanPham;

    @NotBlank(message = "Quốc Gia không được trống!!!")
    @Column(name = "SoLuong")
    public int soLuong;
    @Column(name = "DonGia")
    public int donGia;
    @Column(name = "DonGiaKhiGiam")
    public int donGiaKhiGiam;
}
