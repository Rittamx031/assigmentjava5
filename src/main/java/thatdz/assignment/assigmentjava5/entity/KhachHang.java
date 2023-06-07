package thatdz.assignment.assigmentjava5.entity;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "KhachHang")
@NamedQueries({
    @NamedQuery(
        name = "KhachHang.login",
        query = "SELECT kh FROM KhachHang kh WHERE kh.ma = :ma AND kh.matKhau = :matkhau"
    )
})
public class KhachHang {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "Ma")
    public String ma;
    @Column(name = "Ten")
    public String ten;
    @Column(name = "TenDem")
    public String tenDem;
    @Column(name = "Ho")
    public String ho;
    @Column(name = "Sdt")
    public String sdt;
    @Column(name = "DiaChi")
    public String diaChi;
    @Column(name = "NgaySinh")
    public LocalDate ngaySinh;
    @Column(name = "ThanhPho")
    public String thanhPho;
    @Column(name = "QuocGia")
    public String quocGia;
    @Column(name = "MatKhau")
    public String matKhau;
    @Column(name = "image")
    public String image;
    @Override
    public String toString() {
        return this.ho+" "+this.tenDem +" "+ this.ten;
    }
}
