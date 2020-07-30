package sample.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private User user;


}