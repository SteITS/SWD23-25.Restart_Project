package com.restart.service;

import java.util.List;

import com.restart.entity.Slot;
import com.restart.repository.SlotRepository;

public class SlotServiceImpl implements SlotService{

	private SlotRepository slotDao;

	@Override
	public List<Slot> getSlot() {
		return slotDao.findAll();
	}

	@Override
	public Slot addSlot(Slot slot) {
		return slotDao.save(slot);
	}

	@Override
	public void removeSlot(Slot slot) {
		slotDao.delete(slot);		
	}
	
	
}
