package edu.tecso.crud.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tecso.crud.model.Movement;
import edu.tecso.crud.service.MovementService;

@RestController
@RequestMapping("/api")
public class MovementController {

	private final Logger log = LoggerFactory.getLogger(MovementController.class);
		
	@Autowired
	private MovementService movementService;
		
	@PostMapping("/add-movement")
    ResponseEntity<MovementAddResponse> createAccount(@Valid @RequestBody Movement movement, BindingResult result) throws URISyntaxException {
		if (result.getAllErrors().size() > 0) {
			return new ResponseEntity<MovementAddResponse>(new MovementAddResponse(false, result.getAllErrors().get(0).getDefaultMessage(), null), HttpStatus.OK);
		}
		log.info("Request to create account: {}", movement);
		movement.setDateTime(ZonedDateTime.now(ZoneId.of("UTC-4")));
		Movement mov = movementService.save(movement);
        return ResponseEntity.created(new URI("/api/account/" + mov.getId())).body(new MovementAddResponse(true, null, mov));
    }
	
	@GetMapping("/find-account-movements/{accountId}")
	ResponseEntity<List<Movement>> findAccountMovements(@PathVariable Integer accountId) {
		return ResponseEntity.ok().body(movementService.findAccountMovements(accountId));
	}
	
}
