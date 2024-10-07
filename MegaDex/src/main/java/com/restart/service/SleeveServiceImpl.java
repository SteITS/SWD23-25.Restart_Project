package com.restart.service;

import com.restart.entity.Sleeve;
import com.restart.repository.SleeveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleeveServiceImpl implements SleeveService {
    @Autowired
    private SleeveRepository dao;

    @Override
    public List<Sleeve> getSleeves() {
        return dao.findAll();
    }

    @Override
    public Sleeve saveSleeve(Sleeve sleeve) {
        return dao.save(sleeve);
    }

    @Override
    public void removeSleeve(Sleeve sleeve) {
         dao.delete(sleeve);
    }

}
