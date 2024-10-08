package com.restart.controller;

import com.restart.entity.Sleeve;
import com.restart.entity.User;
import com.restart.service.SleeveService;
import com.restart.service.SleeveServiceImpl;
import com.restart.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import sun.net.ftp.FtpDirEntry;

@RestController
@RequestMapping("/api")
public class SleeveController {
        @Autowired
        private UserServiceImpl userService;
        @Autowired
        private SleeveServiceImpl sleeveService;


    @PostMapping("/addsSleeve")
    public ResponseEntity<Sleeve> addSleeve(@RequestBody Sleeve sleeveRequest) {
        // Recupera l'utente dal database usando l'ID passato nella richiesta

        User user = userService.findUserById(sleeveRequest.getId().getIdUser())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + sleeveRequest.getId().getIdUser()));

        // Crea la nuova Sleeve e associa l'utente
        sleeveRequest.setUser(user);  // Associa l'utente
        // Setta altri campi di Sleeve come necessario


        // Salva la sleeve
        Sleeve savedSleeve = sleeveService.saveSleeve(sleeveRequest);
        return ResponseEntity.ok(savedSleeve);

}

    @PostMapping("/removeSleeve")
    public ResponseEntity<String> removeSleeve(@RequestBody Sleeve sleeveRequest){
        // Recupera l'utente dal database usando l'ID passato nella richiesta

        User user = userService.findUserById(sleeveRequest.getId().getIdUser())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + sleeveRequest.getId().getIdUser()));

        // rimuove la sleeve
        try {
            sleeveService.removeSleeve(sleeveRequest);
            return ResponseEntity.ok("Risorsa eliminata con successo");
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
