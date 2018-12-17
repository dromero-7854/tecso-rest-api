package edu.tecso.crud.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tecso.crud.dto.AccountDTO;
import edu.tecso.crud.exception.BusinessException;
import edu.tecso.crud.model.Account;
import edu.tecso.crud.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	private final Logger log = LoggerFactory.getLogger(AccountController.class);
		
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModelMapper modelMapper;
		
	@PostMapping("/create-account")
    ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) throws URISyntaxException {
        log.info("Request to create account: {}", account);
        Account result = accountService.save(account);
        return ResponseEntity.created(new URI("/api/account/" + result.getId())).body(result);
    }
	
	@DeleteMapping("/delete-account/{id}")
	public ResponseEntity<Response> deleteAccount(@PathVariable Integer id) {
		log.info("Request to delete group: {}", id);
		try {
			accountService.deleteById(id);
		} catch (BusinessException e) {
			return new ResponseEntity<Response>(new Response(false, e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(true, null), HttpStatus.OK);
	}
		
	@GetMapping("/accounts")
	ResponseEntity<List<AccountDTO>> findAll() {
		List<AccountDTO> accounts = accountService.findAll().stream()
															.map(account -> modelMapper.map(account, AccountDTO.class))
															.collect(Collectors.toCollection(ArrayList::new));
		return ResponseEntity.ok().body(accounts);
	}
	
}
