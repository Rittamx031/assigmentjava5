package thatdz.assignment.assigmentjava5.entity.image;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import thatdz.assignment.assigmentjava5.entity.DongSP;

public class DongSPImage {
    @Column(name="Imgurl")
    private String urlImg;
    @Id
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Id", referencedColumnName = "Id")
    @NotNull(message = "dongSP is required")
    private DongSP dongSP;
}
