package edu.tecso.crud.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "currency", nullable = false)
	private Character currency;
		
	@Column(name = "balance", precision = 14, scale = 2, nullable = false) 
	private BigDecimal balance;
	
	@OneToMany
	@JoinColumn(name="account_id")
	@JsonManagedReference
	private Set<Movement> movements;

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

	public Set<Movement> getMovements() {
		return movements;
	}

	public void setMovements(Set<Movement> movements) {
		this.movements = movements;
	}
	
}
