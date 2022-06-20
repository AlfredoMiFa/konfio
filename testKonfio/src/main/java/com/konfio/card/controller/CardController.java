package com.konfio.card.controller;

import com.konfio.card.dto.CardDTO;
import com.konfio.card.entity.CardEntity;
import com.konfio.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/card")
public class CardController {

    private CardService cardService;

    @Autowired
    @Qualifier("cardService1")
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CardEntity saveCard(@RequestBody CardDTO cardDTO) {
        return cardService.createCard(cardDTO);
    }

}
