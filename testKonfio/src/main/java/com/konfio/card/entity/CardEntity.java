package com.konfio.card.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "card")
@Entity
public class CardEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_card")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_card")
    private String numberCard;
    @Column(name = "email")
    private String email;
    @Column(name = "expireDate")
    private String expireDate;
    @Column(name = "buy_limit")
    private int buyLimit;
    @Column(name = "country")
    private String country;

}
