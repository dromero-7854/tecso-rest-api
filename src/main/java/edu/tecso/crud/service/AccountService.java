package edu.tecso.crud.service;

import java.util.List;

import edu.tecso.crud.exception.BusinessException;
import edu.tecso.crud.model.Account;

public interface AccountService {
	
	Character PESO_CURRENCY = 'P';
	
	Character DOLAR_CURRENCY = 'D';
	
	Character EURO_CURRENCY = 'E';
	
	public Account save(Account account);
	
	public void deleteById(Integer id) throws BusinessException;
	
	public Account loadById(Integer id);
	
	public List<Account> findAll();

}
