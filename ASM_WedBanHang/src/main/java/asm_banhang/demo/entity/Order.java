package asm_banhang.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Table(name = "Oders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "createDate")
    private Date createdate;

    @ManyToOne()
    @JoinColumn(name = "Account")
    private Account account;

    @OneToMany(mappedBy = "orderid")
    private List<OrderDetail> list;
}
