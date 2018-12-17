package edu.tecso.crud.dto;

import java.math.BigDecimal;

public class AccountDTO {
	
	private Integer id;
	
	private Character currency;
	
	private BigDecimal balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getCurrency() {
		return currency;
	}

	public void setCurrency(Character currency) {
		this.currency = currency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
