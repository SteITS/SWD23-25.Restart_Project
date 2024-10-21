package com.restart.service;

import com.restart.entity.Sleeve;
import com.restart.entity.SleeveId;

import java.util.List;
import java.util.Optional;

public interface SleeveService {
    List<Sleeve> getSleeves();
    Sleeve saveSleeve(Sleeve sleeve);
    Optional<Sleeve> getSleeveById(SleeveId sleeveId);
    void removeSleeve(Sleeve sleeve);
    List<Sleeve> getSleevesByUserId(int userId);
}
