package thatdz.assignment.assigmentjava5.entity;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    public UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "ma")
    public String ma;
    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "ten")
    public String ten;
    @Override
    public String toString() {
        return this.ten;
    }
}
