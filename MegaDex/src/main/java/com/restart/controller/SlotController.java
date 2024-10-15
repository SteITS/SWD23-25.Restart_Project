package com.restart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restart.entity.Slot;
import com.restart.service.SlotServiceImpl;

@RestController
@RequestMapping("/api")
public class SlotController {
	
	@Autowired
	private SlotServiceImpl slotService;
	
	
	@PostMapping("/saveSlot")
	public ResponseEntity<Slot> addSlot(@RequestBody Slot slot){
		
		Slot savedSlot = slotService.addSlot(slot);
		
		return ResponseEntity.ok(savedSlot);
	}
	
	public ResponseEntity<String> removeSlot(@RequestBody Slot slot){
		try {
            slotService.removeSlot(slot);
            return ResponseEntity.ok("Risorsa eliminata con successo");
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
	}
	
}
