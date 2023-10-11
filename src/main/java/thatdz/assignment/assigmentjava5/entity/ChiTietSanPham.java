package thatdz.assignment.assigmentjava5.entity;

import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@EqualsAndHashCode
@Component
@ToString
@Table(name = "chi_tiet_sp")
@NamedQueries({
        @NamedQuery(name = "ChiTietSanPham.findByDongSP", query = "SELECT cts FROM ChiTietSanPham cts WHERE cts.dongSP.id = :dongSPId")
})

public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_sp", referencedColumnName = "Id")
    @NotNull(message = "Sản phẩm is required")
    public SanPham sanPham;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_nsx", referencedColumnName = "Id")
    @NotNull(message = "Nhà sản xuất is required")
    public NSX nsx;

    @NotNull(message = "Màu Sắc is required")
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_mau_sac", referencedColumnName = "Id")
    public MauSac mauSac;
    @NotNull(message = "Dòng sản phẩm is required")
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "id_dong_sp", referencedColumnName = "Id")
    public DongSP dongSP;

    @Min(value = 1, message = "Năm bảo hành must be at least 1")
    @Column(name = "nam_bh")
    public int namBH;

    @Min(value = 0, message = "Số lượng tồn must be greater than or equal to 0")
    @Column(name = "so_luong_ton")
    public int soLuongTon;

    @Min(value = 0, message = "Giá nhập must be greater than or equal to 0")
    @Column(name = "gia_nhap")
    public double giaNhap;

    @Min(value = 0, message = "Giá bán must be greater than or equal to 0")
    @Column(name = "gia_ban")
    public double giaBan;
    @Column(name = "image")
    public String image;
}
