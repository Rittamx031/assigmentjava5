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
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "Ma")
    private String ma;
    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "Ten")
    private String ten;
    @Override
    public String toString() {
        return this.ten;
    }
}
