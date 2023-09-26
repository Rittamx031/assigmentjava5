package thatdz.assignment.assigmentjava5.dto.request;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;

/**
 * GioHangViewModel
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GioHangViewModel {
    public GioHangChiTietKey id;

    public String tenSanpham;

    public String image;

    public int soLuong;

    public double gia;

    public double tong;

    public double getTongTien(){
        tong = gia*soLuong;
        return tong;
    }
}