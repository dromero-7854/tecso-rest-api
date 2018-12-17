package edu.tecso.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.tecso.crud.model.Account;

public interface AccountRepository extends  JpaRepository<Account, Integer> {

}
