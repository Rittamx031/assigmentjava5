package asm_banhang.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "OrderDetails")
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double price;

    private Integer quantity;


    @ManyToOne()
    @JoinColumn(name = "orderid")
    private Order orderid;

    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product productid;

}
