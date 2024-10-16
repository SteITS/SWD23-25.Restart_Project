package com.restart.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.restart.entity.DeckPass;
import com.restart.entity.Slot;

@Service
public interface SlotService {
	
	List<Slot> getSlot();
	
	Slot addSlot(Slot slot);
	
	void removeSlot(Slot slot);
	
	DeckPass validateSlots(List<Slot> slots);
}
