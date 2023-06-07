package thatdz.assignment.assigmentjava5.entity.image;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@ToString
public class SanPhamImage {
    @Column(name="Imgurl")
    private String urlImg;
    @Column(name="viewable")
    private boolean viewable;
    @Column(name="viewinhomepage")
    private boolean viewinhomepage;
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdSp", referencedColumnName = "Id")
    @NotNull(message = "ChiTetSamPham is required")
    private ChiTietSanPham chiTietSanPham;
}
