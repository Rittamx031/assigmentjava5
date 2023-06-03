package thatdz.assignment.assigmentjava5.entity;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNSX", referencedColumnName = "Id")
    private NSX nsx;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSP dongSP;
    @Column(name = "NamBH")
    private int namBH;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "GiaNhap")
    private double giaNhap;
    @Column(name = "GiaBan")
    private double giaBan;
    @OneToMany(mappedBy = "chiTietSanPham")
    List<GioHangChiTiet> gioHangChiTiets;
}
