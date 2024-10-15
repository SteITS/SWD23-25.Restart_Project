package com.restart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restart.entity.Slot;
import com.restart.entity.SlotId;

@Repository
public interface SlotRepository extends JpaRepository<Slot, SlotId>{

}
