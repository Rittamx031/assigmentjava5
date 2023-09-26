package thatdz.assignment.assigmentjava5.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
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
@Table(name = "cua_hang")
@NamedQuery(
        name ="CuaHang.search",
        query ="SELECT ch FROM CuaHang ch Where ten LIKE CONCAT('%',:query, '%') OR ma LIKE CONCAT('%',:query, '%')"
)
public class CuaHang {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    public UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "ma")
    public String ma;
//     SELECT TOP (1000) [id]
//       ,[ma]
//       ,[ten]
//       ,[dia_chi]
//       ,[thanh_pho]
//       ,[quoc_gia]
//   FROM [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041].[dbo].[cua_hang]

    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "ten")
    public String ten;

    @NotBlank(message = "Địa chỉ không được trống!!!")
    @Column(name = "dia_chi")
    public String diaChi;

    @NotBlank(message = "Thành Phố không được trống!!!")
    @Column(name = "thanh_pho")
    public String thanhPho;

    @NotBlank(message = "Quốc Gia không được trống!!!")
    @Column(name = "quoc_gia")
    public String quocGia;
    @Override
    public String toString() {
        return this.ten;
    }
}
