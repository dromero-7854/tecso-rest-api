package edu.tecso.crud.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.tecso.crud.validator.AccountMovementAllowed;

@AccountMovementAllowed.List({ 
	@AccountMovementAllowed(
		accountField = "account",	
		typeField = "type", 
		amountField = "amount", 
		message = "invalid account movement"
	)
})
@Entity
@Table(name = "movement")
public class Movement {
	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "zoned_date_time", nullable = false)
	private ZonedDateTime dateTime;
	
	@Column(name = "type", nullable = false)
	private Character type;
	
	@Column(name = "description", nullable = false, length = 200)
	private String description;
	
	@Column(name = "amount", precision = 14, scale = 2, nullable = false)
	private BigDecimal amount;
	
	@ManyToOne
	@JsonBackReference
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
