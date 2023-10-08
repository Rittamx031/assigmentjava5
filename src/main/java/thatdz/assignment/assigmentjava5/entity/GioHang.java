package thatdz.assignment.assigmentjava5.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import groovy.transform.ToString;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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
@ToString
@Table(name = "gio_hang")
@NamedQueries({
        @NamedQuery(name = "GioHang.getGioHangbyKhachHang", query = "SELECT gh FROM GioHang gh WHERE gh.khachHang.id =:idKhachHang")
})
public class GioHang {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    public UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "ma")
    public String ma;

    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "ten_nguoi_nhan")
    public String tenNguoiNhan;

    @Column(name = "ngay_tao")
    public LocalDate ngayTao;

    @Column(name = "ngay_thanh_toan")
    public LocalDate ngayThanhToan;

    @NotBlank(message = "Địa chỉ không được trống!!!")
    @Column(name = "dia_chi")
    public String diaChi;

    @Column(name = "sdt")
    public String sdt;

    @Column(name = "tinh_trang")
    public int tinhTrang;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_kh", referencedColumnName = "Id")
    private KhachHang khachHang;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_nv", referencedColumnName = "Id")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "gioHang")
    List<GioHangChiTiet> gioHangChiTiets;

    @Override
    public String toString() {
        return this.tenNguoiNhan;
    }
}
