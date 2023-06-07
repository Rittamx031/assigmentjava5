package thatdz.assignment.assigmentjava5.entity;

import java.sql.Date;

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
    @NotBlank(message = "Mã không được trống!!!")
    public String ma;
    @NotBlank(message = "Tên không được trống!!!")
    public String ten;
    public String tenDem;
    @NotBlank(message = "Họ được trống!!!")
    public String ho;
    public Date ngaySinh;
    @NotBlank(message = "Địa chỉ được trống!!!")
    public String diaChi;
    @NotBlank(message = "Thành phố được trống!!!")
    public String thanhPho;
    @NotBlank(message = "Quốc gia được trống!!!")
    public String quocGia;
    @NotBlank(message = "Mật khẩu được trống!!!")
    public String matKhau;
    @NotNull(message = "Giới Tính không đuợc để trống!!!")
    public boolean gioiTinh;
    @NotNull(message = "Nhập lại mật khẩu không đuợc để trống!!!")
    public String matKhaurepeat;
}
