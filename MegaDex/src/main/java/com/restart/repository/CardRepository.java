package com.restart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restart.entity.Card;

public interface CardRepository extends JpaRepository<Card, String>{

	List<Card> findAll();
	List<Card> findByName(String name);
}
