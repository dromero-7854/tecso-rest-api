package edu.tecso.crud.service;

import java.util.List;

import edu.tecso.crud.model.Movement;

public interface MovementService {

	Character DEBIT_MOV = 'D';
	
	Character CREDIT_MOV = 'C';
	
	public Movement save(Movement movement);
	
	public List<Movement> findAccountMovements(Integer accountId);
	
}
