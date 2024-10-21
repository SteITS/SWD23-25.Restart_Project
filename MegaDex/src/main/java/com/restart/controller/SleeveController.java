package com.restart.controller;

import com.restart.entity.Card;
import com.restart.entity.Sleeve;
import com.restart.entity.SleeveId;
import com.restart.entity.User;
import com.restart.service.CardServiceImpl;
import com.restart.service.SleeveServiceImpl;
import com.restart.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import sun.net.ftp.FtpDirEntry;

@RestController
@RequestMapping("/api")
public class SleeveController {
        @Autowired
        private UserServiceImpl userService;
        @Autowired
        private CardServiceImpl cardService;
        @Autowired
        private SleeveServiceImpl sleeveService;


    //Aggiorna o rimuove una Sleeve
    @PostMapping("/auth/updateSleeve")
    public ResponseEntity<Sleeve> updateSleeve(@RequestBody Sleeve sleeveRequest) {
            // Recupera l'utente autenticato
            User user = userService.getAuthenticatedUser();

        Card card = cardService.getCardById(sleeveRequest.getId().getIdCard())
                .orElseThrow(() -> new RuntimeException("Card not found with ID: " + sleeveRequest.getId().getIdUser()));


        // associa carta e utente
        sleeveRequest.setUser(user);
        sleeveRequest.getId().setIdUser(user.getId());
        sleeveRequest.setCard(card);


        // Salva la sleeve se quantity è maggiore di 0
        if(sleeveRequest.getQuantity()>0){
        Sleeve savedSleeve = sleeveService.saveSleeve(sleeveRequest);
        return ResponseEntity.ok(savedSleeve);
        }
        // Altrimenti elimina la sleeve
        else {
            sleeveService.removeSleeve(sleeveRequest);
            return ResponseEntity.ok(sleeveRequest);
        }

}
    //Rimuove una sleeve
    @PostMapping("/auth/removeSleeve")
    public ResponseEntity<String> removeSleeve(@RequestBody Sleeve sleeveRequest){
        // Recupera l'utente autenticato
        User user = userService.getAuthenticatedUser();
        Card card = cardService.getCardById(sleeveRequest.getId().getIdCard())
                .orElseThrow(() -> new RuntimeException("Card not found with ID: " + sleeveRequest.getId().getIdUser()));

        // associa carta e utente
        sleeveRequest.setUser(user);
        sleeveRequest.getId().setIdUser(user.getId());
        sleeveRequest.setCard(card);

        // rimuove la sleeve
        try {
            sleeveService.removeSleeve(sleeveRequest);
            return ResponseEntity.ok("Carte rimosse con successo");
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    
 // endpoint per ottenere le sleeves dell'utente autenticato
    @GetMapping("/auth/mySleeves")
    public ResponseEntity<List<Sleeve>> getMySleeves() {
        // Recupera l'utente autenticato
        User user = userService.getAuthenticatedUser();
        
        // Ottiene tutte le sleeves dell'utente autenticato
        List<Sleeve> sleeves = sleeveService.getSleevesByUserId(user.getId());
        
        // Se non ci sono sleeves, restituisce no content
        if (sleeves.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        // Altrimenti restituisce le sleeves
        return ResponseEntity.ok(sleeves);
    }

    @GetMapping("/auth/mySleeve")
    public ResponseEntity<Sleeve> getMySleeve(@RequestParam String cardRequest) {
        SleeveId sleeveId = new SleeveId();

        // Recupera l'utente autenticato
        User user = userService.getAuthenticatedUser();

        sleeveId.setIdUser(user.getId());
        sleeveId.setIdCard(cardRequest);

        // Ottiene tutte le sleeves dell'utente autenticato
        Sleeve sleeve = sleeveService.getSleeveById(sleeveId)
                .orElseThrow(() -> new RuntimeException("Card not found with ID: " + cardRequest));

        // Se non ci sono sleeves, restituisce no content
        if (sleeve == null) {
            return ResponseEntity.noContent().build();
        }

        // Altrimenti restituisce la sleeve
        return ResponseEntity.ok(sleeve);
    }
}
