package thatdz.assignment.assigmentjava5.entity;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "DongSp")
public class DongSP {
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
    @OneToMany(cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JoinColumn(mappedBy = "post",
    )
    private Set<ChiTietSanPham>  chiTietSanPhams;      
    @Override
    public String toString() {
        return this.ten;
    }
}
