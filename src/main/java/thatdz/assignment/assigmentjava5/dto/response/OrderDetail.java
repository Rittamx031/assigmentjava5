package thatdz.assignment.assigmentjava5.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
  List<ProductDetail> listhdct;
  String name;
  String phoneNumber;
  String address;
  LocalDate ngayTao;
  LocalDate ngayThanhToan;
  Double totalPrice;
  String trangThai;
}
