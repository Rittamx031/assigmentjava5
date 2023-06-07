package thatdz.assignment.assigmentjava5.entity;


import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Component
public class SignUp {
    @NotBlank(message = "Mã không không được trống!!!")
    public String ma;
    @NotBlank(message = "Tên không không được trống!!!")
    public String ten;
    public String tenDem;
    @NotBlank(message = "Họ không được trống!!!")
    public String ho;
    @NotNull(message = "Ngày Sinh không được trống!!!")
    public LocalDate ngaySinh;
    @NotBlank(message = "Địa chỉ không được trống!!!")
    public String diaChi;
    @NotBlank(message = "Thành phố không được trống!!!")
    public String thanhPho;
    @NotBlank(message = "Quốc gia không được trống!!!")
    public String quocGia;
    @NotBlank(message = "Mật khẩu không được trống!!!")
    public String matKhau;
    @NotNull(message = "Giới Tính không đuợc để trống!!!")
    public boolean gioiTinh;
    @NotBlank(message = "Số điện thoại không đuợc để trống!!!")
    public String sdt;
    @NotBlank(message = "Nhập lại mật khẩu không đuợc để trống!!!")
    public String matKhaurepeat;
    public String image;
}
