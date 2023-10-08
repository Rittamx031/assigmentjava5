package thatdz.assignment.assigmentjava5.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@EqualsAndHashCode
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_kh", referencedColumnName = "id")
    private KhachHang khachHang;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_nv", referencedColumnName = "id")
    private NhanVien nhanVien;
    @Column(name = "ma")
    private String ma;
    @NotNull
    @NotBlank
    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;
    @NotNull
    @NotBlank
    @Column(name = "dia_chi")
    private String diaChi;
    @NotNull
    @NotBlank
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "tinh_trang")
    private int tinhTrang;
    @Column(name = "ngay_tao")
    private LocalDate ngayTao;
    @Column(name = "ngay_thanh_toan")
    private LocalDate ngayThanhToan;
    @Column(name = "ngay_ship")
    private LocalDate ngayShip;
    @Column(name = "ngay_nhan")
    private LocalDate ngayNhan;
}
