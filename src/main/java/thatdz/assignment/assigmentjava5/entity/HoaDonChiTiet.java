package thatdz.assignment.assigmentjava5.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class HoaDonChiTiet {
  @EmbeddedId
  HoaDonChiTietKey id;

  @ManyToOne
  @MapsId("idHoaDon")
  @JoinColumn(name = "id_hoa_don")
  GioHang gioHang;

  @ManyToOne
  @MapsId("idChiTietSP")
  @JoinColumn(name = "id_chi_tiet_sp")
  ChiTietSanPham chiTietSanPham;

  @Column(name = "")
  int soLuong;
  @Column(name = "don_gia")
  double donGia;
}
