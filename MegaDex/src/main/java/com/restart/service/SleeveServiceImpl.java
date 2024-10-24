package com.restart.service;

import com.restart.entity.Sleeve;
import com.restart.entity.SleeveId;
import com.restart.repository.SleeveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Sleeve> getSleeveById(SleeveId sleeveId) {
        return dao.findById(sleeveId);
    }

    // Elimina una bustina dal database tramite il suo ID
    @Override
    public void removeSleeve(Sleeve sleeve) {
        dao.deleteById(sleeve.getId());
    }
    //nuovo metodo per ottenere le sleeves tramite ID utente
    @Override
    public List<Sleeve> getSleevesByUserId(int userId) {
        return dao.findByUserId(userId);
    }
}