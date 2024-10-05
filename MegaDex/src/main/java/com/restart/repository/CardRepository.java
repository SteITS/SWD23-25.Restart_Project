package com.restart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restart.entity.Card;
@Repository
public interface CardRepository extends JpaRepository<Card, String>{

	List<Card> findAll();
	List<Card> findByName(String name);
	List<Card> findBySupertypeName(String name);
}
