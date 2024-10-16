package com.restart.repository;

import com.restart.entity.Sleeve;
import com.restart.entity.SleeveId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SleeveRepository extends JpaRepository<Sleeve, SleeveId> {

}
