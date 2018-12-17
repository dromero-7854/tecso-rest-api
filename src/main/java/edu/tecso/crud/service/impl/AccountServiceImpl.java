package edu.tecso.crud.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tecso.crud.exception.BusinessException;
import edu.tecso.crud.model.Account;
import edu.tecso.crud.repository.AccountRepository;
import edu.tecso.crud.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRep;

	public Account save(Account account) {
		account.setBalance(new BigDecimal(0));
		Account result = accountRep.save(account);
		return result;
	}

	public void deleteById(Integer id) throws BusinessException {
		if (accountRep.existsById(id)) {
			if (accountRep.findById(id).get().getMovements().size() == 0) {
				accountRep.deleteById(id);			
			} else {
				throw new BusinessException("La cuenta tiene movimientos asociados");
			}
		} else {
			throw new BusinessException("Cuenta inexistente");
		}
	}

	public Account loadById(Integer id) {
		return accountRep.findById(id).get();
	}
	
	public List<Account> findAll() {
		return accountRep.findAll();
	}
	
}
