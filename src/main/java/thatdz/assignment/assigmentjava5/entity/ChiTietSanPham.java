package thatdz.assignment.assigmentjava5.entity;

import java.util.Set;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
@Table(name = "ChiTietSP")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    @NotNull(message = "Sản phẩm is required")
    private SanPham sanPham;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNSX", referencedColumnName = "Id")
    @NotNull(message = "Nhà sản xuất is required")
    private NSX nsx;

    @NotNull(message = "Màu Sắc is required")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;
    
    @NotNull(message = "Dòng sản phẩm is required")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSP dongSP;

    @Min(value = 1, message = "Năm bảo hành must be at least 1")
    @Column(name = "NamBH")
    private int namBH;

    @Min(value = 0, message = "Số lượng tồn must be greater than or equal to 0")
    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Min(value = 0, message = "Giá nhập must be greater than or equal to 0")
    @Column(name = "GiaNhap")
    private double giaNhap;

    @Min(value = 0, message = "Giá bán must be greater than or equal to 0")
    @Column(name = "GiaBan")
    private double giaBan;

    @OneToMany(mappedBy = "chiTietSanPham")
    Set<GioHangChiTiet> gioHangChiTiets;
}
