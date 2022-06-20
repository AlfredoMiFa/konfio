package com.konfio.card.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CardDTO implements Serializable {

    private String id;
    private String name;
    private String numberCard;
    private String email;
    private String expireDate;
    private int buyLimit;
    private String country;

}
