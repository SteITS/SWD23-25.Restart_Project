package com.restart.repository;

import com.restart.entity.Slot;
import com.restart.entity.SlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, SlotId> {
}
