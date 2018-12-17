package edu.tecso.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tecso.crud.model.Movement;
import edu.tecso.crud.repository.MovementRepository;
import edu.tecso.crud.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	private MovementRepository movementRep;
	
	public Movement save(Movement movement) {
		Movement result = movementRep.save(movement);
		return result;
	}

	public List<Movement> findAccountMovements(Integer accountId) {
		return movementRep.findAccountMovements(accountId);
	}
	
}
