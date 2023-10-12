package thatdz.assignment.assigmentjava5.dto.request;

import java.util.UUID;

import org.springframework.stereotype.Component;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * HoaDonRequest
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@FieldDefaults(level = AccessLevel.PUBLIC)
public class HoaDonRequest {
  UUID id;
  @NotNull
  @NotBlank
  @Column(name = "ten_nguoi_nhan")
  String tenNguoiNhan;
  @NotNull
  @NotBlank
  @Column(name = "dia_chi")
  String diaChi;
  @NotNull
  @NotBlank
  @Column(name = "sdt")
  String sdt;
}