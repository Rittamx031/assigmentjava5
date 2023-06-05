package thatdz.assignment.assigmentjava5.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "Ma")
    public String ma;

    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "Ten")
    public String ten;
    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "TenDem")
    public String tenDem;
    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "Ho")
    public String ho;

    @NotBlank(message = "Địa chỉ không được trống!!!")
    @Column(name = "DiaChi")
    public String diaChi;

    @Column(name = "NgaySinh")
    public Date ngaySinh;
    @NotBlank(message = "Thành Phố không được trống!!!")
    @Column(name = "ThanhPho")
    public String thanhPho;

    @NotBlank(message = "Quốc Gia không được trống!!!")
    @Column(name = "QuocGia")
    public String quocGia;
    @Column(name = "MatKhau")
    public String matKhau;

    @Override
    public String toString() {
        return this.ten;
    }
}
