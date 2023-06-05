package thatdz.assignment.assigmentjava5.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * NhanVien
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id")
    public UUID id;

    @NotBlank(message = "Ma không được để trống")
    @Column(name = "Ma")
    public String ma;

    @NotBlank(message = "Tên không được để trống")
    @Column(name = "Ten")
    public String ten;

    @Column(name = "TenDem")
    public String tenDem;

    @NotBlank(message = "Họ không được để trống")
    @Column(name = "Ho")
    public String ho;

    @NotNull(message = "Giới Tính Không được bỏ qua")
    @Column(name = "GioiTinh")
    public Boolean gioiTinh;

    @NotNull(message = "Ngày Sinh Không được bỏ qua")
    @Column(name = "NgaySinh")
    public LocalDate ngaySinh;

    @NotBlank(message = "Địa Chỉ không được để trống")
    @Column(name = "DiaChi")
    public String diaChi;

    @NotBlank(message = "Số Điện Thoại không được để trống")
    @Pattern(regexp = "\\d{10}", message = "Sdt must be a 10-digit number")
    @Column(name = "Sdt")
    public String sdt;
    
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private ChucVu chucvu;

    @ManyToOne(cascade  = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdGuiBC", referencedColumnName = "Id")
    private NhanVien quanly;

    @Column(name = "TrangThai")
    public int trangThai;
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdCH", referencedColumnName = "Id")
    private CuaHang cuahang;

    public String getFullName(){
        return this.ho +" "+ this.tenDem + " "+this.getTen();
    }
}