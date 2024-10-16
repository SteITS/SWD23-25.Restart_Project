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

    // Recupera tutte le bustine dal database
    @Override
    public List<Sleeve> getSleeves() {
        return dao.findAll();
    }

    // Salva una nuova bustina nel database
    @Override
    public Sleeve saveSleeve(Sleeve sleeve) {
        return dao.save(sleeve);
    }

    // Elimina una bustina dal database tramite il suo ID
    @Override
    public void removeSleeve(Sleeve sleeve) {
        dao.deleteById(sleeve.getId());
    }
}