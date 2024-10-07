package com.restart.repository;

import com.restart.entity.Card;
import com.restart.entity.Sleeve;
import com.restart.entity.SleeveId;
import com.restart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SleeveRepository extends JpaRepository<Sleeve, SleeveId> {

}
