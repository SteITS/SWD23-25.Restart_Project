package com.restart.service;

import com.restart.entity.Sleeve;

import java.util.List;

public interface SleeveService {
    List<Sleeve> getSleeves();
    Sleeve saveSleeve(Sleeve sleeve);

    void removeSleeve(Sleeve sleeve);
}
