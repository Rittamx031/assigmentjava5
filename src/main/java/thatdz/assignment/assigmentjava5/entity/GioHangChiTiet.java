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
@Table(name = "gio_hang_chi_tiet")
@NamedQueries({
        @NamedQuery(name = "GioHangChiTiet.getGioHangChiTietByGioHang", query = "SELECT ctgh FROM GioHangChiTiet ctgh WHERE ctgh.gioHang.id =: idgiohang")
})
public class GioHangChiTiet {
    @EmbeddedId
    GioHangChiTietKey id;
    // SELECT TOP (1000) [id_gio_hang]
    // ,[id_chi_tiet_sp]
    // ,[so_luong]
    // ,[don_gia]
    // ,[don_gia_khi_giam]
    // FROM [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041].[dbo].[gio_hang_chi_tiet]

    @ManyToOne
    @MapsId("idGioHang")
    @JoinColumn(name = "id_gio_hang")
    GioHang gioHang;

    @ManyToOne
    @MapsId("idChiTietSP")
    @JoinColumn(name = "id_chi_tiet_sp")
    ChiTietSanPham chiTietSanPham;

    @Column(name = "so_luong")
    public int soLuong;
    @Column(name = "don_gia")
    public double donGia;
    @Column(name = "don_gia_khi_giam")
    public double donGiaKhiGiam;

}
