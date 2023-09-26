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
@Table(name = "dong_sp")
public class DongSP {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @NotBlank(message = "Mã không được trống!!!")
    @Column(name = "ma")
    private String ma;
    @NotBlank(message = "Tên không được trống!!!")
    @Column(name = "ten")
    private String ten;

    @Column(name = "ImageName")
    private String imageName;

    @Override
    public String toString() {
        return this.ten;
    }
}
