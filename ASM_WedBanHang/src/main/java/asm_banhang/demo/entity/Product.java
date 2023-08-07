package asm_banhang.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    private Double price;


    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "avaliable")
    private Long avaliable;

    @ManyToOne()
    @JoinColumn(name = "categoryid")
    private Categories categories;

    @JsonIgnore
    @OneToMany(mappedBy = "productid")
    private List<OrderDetail> list;
}
