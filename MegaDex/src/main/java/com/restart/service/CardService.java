package com.restart.service;

import com.restart.dto.CardDto;
//Repository interface that extends JpaRepository and JpaSpecificationExecutor to allow custom query building with filtering support
public interface CardService {

    CardDto getFilteredCards(
    		String Id,
    		String name,
    		String supertype,
    		String type,
    		String subtype,
    		String set,
    		int page,
    		String orderBy,
    		String direction
    		);	
}
