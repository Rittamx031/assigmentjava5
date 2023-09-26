package thatdz.assignment.assigmentjava5.entity;

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
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTietKey {
  @Column(name = "id_hoa_don")
  UUID idHoaDon;

  @Column(name = "id_chi_tiet_sp")
  UUID idChiTietSP;

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof HoaDonChiTietKey))
      return false;
    HoaDonChiTietKey other = (HoaDonChiTietKey) obj;
    return Objects.equals(idHoaDon, other.idHoaDon) && Objects.equals(idChiTietSP, other.idChiTietSP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idHoaDon, idChiTietSP);
  }

}
