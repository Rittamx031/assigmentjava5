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
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    public UUID id;

    @NotBlank(message = "Ma không được để trống")
    @Column(name = "ma")
    public String ma;

    @NotBlank(message = "Tên không được để trống")
    @Column(name = "ten")
    public String ten;

    @Column(name = "ten_dem")
    public String tenDem;

    @NotBlank(message = "Họ không được để trống")
    @Column(name = "ho")
    public String ho;
    // [id]
    // ,[ma]
    // ,[ten]
    // ,[ten_dem]
    // ,[ho]
    // ,[gioi_tinh]
    // ,[ngay_sinh]
    // ,[dia_chi]
    // ,[sdt]
    // ,[mat_khau]
    // ,[id_ch]
    // ,[id_cv]
    // ,[id_gui_bc]
    // ,[trang_thai]
    @NotNull(message = "Giới Tính Không được bỏ qua")
    @Column(name = "gioi_tinh")
    public Boolean gioiTinh;

    @NotNull(message = "Ngày Sinh Không được bỏ qua")
    @Column(name = "ngay_sinh")
    public LocalDate ngaySinh;

    @NotBlank(message = "Địa Chỉ không được để trống")
    @Column(name = "dia_chi")
    public String diaChi;

    @NotBlank(message = "Số Điện Thoại không được để trống")
    @Pattern(regexp = "\\d{10}", message = "Sdt must be a 10-digit number")
    @Column(name = "sdt")
    public String sdt;
    
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_cv", referencedColumnName = "Id")
    private ChucVu chucvu;

    @ManyToOne(cascade  = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_gui_bc", referencedColumnName = "Id")
    private NhanVien quanly;

    @Column(name = "trang_thai")
    public int trangThai;
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_ch", referencedColumnName = "Id")
    private CuaHang cuahang;

    public String getFullName(){
        return this.ho +" "+ this.tenDem + " "+this.getTen();
    }
}