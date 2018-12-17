package edu.tecso.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tecso.crud.model.Movement;

public interface MovementRepository extends  JpaRepository<Movement, Integer> {
	
	@Query("select mov from Movement mov where mov.account.id=?1 order by mov.dateTime desc")
	public List<Movement> findAccountMovements(Integer accountId);
	
}
