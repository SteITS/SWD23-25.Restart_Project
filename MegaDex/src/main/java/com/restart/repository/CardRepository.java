package com.restart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.restart.entity.Card;

//Repository interface that extends JpaRepository and JpaSpecificationExecutor to allow 
//custom query building with filtering support.
@Repository
public interface CardRepository extends JpaRepository<Card, String>,JpaSpecificationExecutor<Card>{
	
}
