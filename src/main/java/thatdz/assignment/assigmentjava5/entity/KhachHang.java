package thatdz.assignment.assigmentjava5.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
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
@Table(name = "khach_hang")
@NamedQueries({
        @NamedQuery(name = "KhachHang.login", query = "SELECT kh FROM KhachHang kh WHERE kh.ma = :ma AND kh.matKhau = :matkhau")
})
public class KhachHang {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "ma")
    public String ma;
    @Column(name = "ten")
    public String ten;
    @Column(name = "ten_dem")
    public String tenDem;
    @Column(name = "ho")
    public String ho;
    @Column(name = "Sdt")
    public String sdt;
    @Column(name = "dia_chi")
    public String diaChi;
    @Column(name = "ngay_sinh")
    public LocalDate ngaySinh;
    @Column(name = "thanh_pho")
    public String thanhPho;
    @Column(name = "quoc_gia")
    public String quocGia;
    @Column(name = "mat_khau")
    public String matKhau;
    @Column(name = "image")
    public String image;

    @Override
    public String toString() {
        return this.ho + " " + this.tenDem + " " + this.ten;
    }

    public String getAddress() {
        return this.getDiaChi() + ", " + this.getThanhPho() + ", " + this.getQuocGia();
    }

    public String getFullName() {
        if (!this.getTen().equals("")) {
            return this.getHo() + " " + this.getTenDem() + " " + this.getTen();
        }
        return this.getHo() + " " + this.getTen();
    }
}
