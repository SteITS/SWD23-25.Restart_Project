package com.restart.service;

import com.restart.entity.DeckPass;
import com.restart.entity.Slot;

import java.util.List;

public interface SlotService {
    DeckPass validateSlots(List<Slot> slots);
}
