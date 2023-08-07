package asm_banhang.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Authorities")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorities {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "username")
    private String username;

    @ManyToOne()
    @JoinColumn(name = "Roles")
    private Role role;

    @ManyToOne()
    @JoinColumn(name = "Account")
    private Account account;
}
