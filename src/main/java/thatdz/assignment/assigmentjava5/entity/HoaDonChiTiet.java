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
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@EqualsAndHashCode
@Table(name = "hoa_don_chi_tiet")
@NamedQueries({
  @NamedQuery(name = "HoaDonChiTiet.getListSanPham", query = "SELECT hdct.chiTietSanPham.id FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.id =:idHoaDon")
})
public class HoaDonChiTiet {
  @EmbeddedId
  HoaDonChiTietKey id;

  @ManyToOne
  @MapsId("idHoaDon")
  @JoinColumn(name = "id_hoa_don")
  HoaDon hoaDon;

  @ManyToOne
  @MapsId("idChiTietSP")
  @JoinColumn(name = "id_chi_tiet_sp")
  public ChiTietSanPham chiTietSanPham;

  @Column(name = "so_luong")
  int soLuong;
  @Column(name = "don_gia")
  double donGia;
}
