package com.konfio.card.service;

import com.konfio.card.dto.CardDTO;
import com.konfio.card.entity.CardEntity;
import com.konfio.card.exception.BadCardException;
import com.konfio.card.exception.BadLimitBuyException;
import com.konfio.card.exception.BadNameException;
import com.konfio.card.repository.CardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@Qualifier("cardService1")
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardEntity createCard(CardDTO cardDTO) {
        matchesField(cardDTO);
        CardEntity cardEntity = new CardEntity();
        cardEntity.setNumberCard(cardDTO.getNumberCard());
        cardEntity.setCountry(cardEntity.getCountry());
        cardEntity.setBuyLimit(cardDTO.getBuyLimit());
        cardEntity.setEmail(cardEntity.getEmail());
        cardEntity.setExpireDate(cardDTO.getExpireDate());
        CardEntity cardEntitySaved = cardRepository.save(cardEntity);
        return cardEntitySaved;
    }

    @Override
    public CardEntity updateCard(CardDTO cardDTO, String id) {
        return null;
    }

    @Override
    public void deleteCard(String id) {

    }

    @Override
    public List<CardEntity> findCards(String name, String country) {
        return null;
    }

    private void matchesField(CardDTO cardDTO) {
        String matcherLetter = "[a-zA-Z]+";
        if(!cardDTO.getName().matches(matcherLetter) || cardDTO.getName().length()>15) {
            log.info("name not good "+cardDTO.getName());
            throw new BadNameException();
        }
        String matcherCard = "^4[0-9]{12}(?:[0-9]{3})?$";
        if(!cardDTO.getNumberCard().matches(matcherCard) || cardDTO.getNumberCard().length() != 16) {
            log.info("card not good "+cardDTO.getNumberCard());
            throw new BadCardException();
        }
        if(cardDTO.getBuyLimit()<100 || cardDTO.getBuyLimit()>1000000) {
            log.info("buy limit not good "+cardDTO.getBuyLimit());
            throw new BadLimitBuyException();
        }
    }

}
