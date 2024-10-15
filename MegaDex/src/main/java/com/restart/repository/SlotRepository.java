package com.restart.repository;

import com.restart.entity.Slot;
import com.restart.entity.SlotId;
import com.restart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SlotRepository extends JpaRepository<Slot, SlotId> {
}
