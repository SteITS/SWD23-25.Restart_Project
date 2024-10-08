package com.restart.repository;

import com.restart.entity.Rating;
import com.restart.entity.SleeveId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, SleeveId> {

}
