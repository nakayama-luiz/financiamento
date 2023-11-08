package model;


import javax.persistence.*;

@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idreceita")
    private int id;


}
