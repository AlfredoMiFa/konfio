package com.konfio.card.repository;

import com.konfio.card.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository <CardEntity, String> {



}
