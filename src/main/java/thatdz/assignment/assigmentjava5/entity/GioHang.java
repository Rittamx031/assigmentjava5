package thatdz.assignment.assigmentjava5.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "GioHang")
public class GioHang {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    public UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "Ma")
    public String ma;

    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "TenNguoiNhan")
    public String tenNguoiNhan;

    @Column(name = "NgayTao")
    public Date ngayTao;

    @Column(name = "NgayThanhToan")
    public Date ngayThanhToan;

    @NotBlank(message = "Địa chỉ không được trống!!!")
    @Column(name = "DiaChi")
    public String diaChi;

    @Column(name = "Sdt")
    public String sdt;

    @Column(name = "TinhTrang")
    public int tinhTrang;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")

    private KhachHang khachHang;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private NhanVien nhanVien;
    
    @ManyToMany
    @JoinTable(name = "GioHangChiTiet", joinColumns = @JoinColumn(name = "IdChiTietSP"), inverseJoinColumns = @JoinColumn(name = "IdGioHang"))
    List<ChiTietSanPham> chiTietSanPhams;

    @Override
    public String toString() {
        return this.tenNguoiNhan;
    }
}
