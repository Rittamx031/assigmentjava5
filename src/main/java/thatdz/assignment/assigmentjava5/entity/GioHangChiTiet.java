package thatdz.assignment.assigmentjava5.entity;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {
    @NotBlank(message = "Quốc Gia không được trống!!!")
    @Column(name = "SoLuong")
    public int soLuong;
    @Column(name = "DonGia")
    public int donGia;
    @Column(name = "DonGiaKhiGiam")
    public int donGiaKhiGiam;
}
