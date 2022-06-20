package com.konfio.card.service;

import com.konfio.card.dto.CardDTO;
import com.konfio.card.entity.CardEntity;

import java.util.List;

public interface CardService {

    public CardEntity createCard(CardDTO cardDTO);
    public CardEntity updateCard(CardDTO cardDTO, String id);
    public void deleteCard(String id);
    public List<CardEntity> findCards(String name, String country);

}
