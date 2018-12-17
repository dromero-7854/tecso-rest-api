package edu.tecso.crud.validator;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import edu.tecso.crud.model.Account;
import edu.tecso.crud.service.AccountService;
import edu.tecso.crud.service.MovementService;

public class AccountMovementAllowedValidator implements ConstraintValidator<AccountMovementAllowed, Object> {

	@Autowired
	private AccountService accountService;
	
	private String accountField;
	
	private String typeField;
	
    private String amountField;
	
    public void initialize(AccountMovementAllowed constraintAnnotation) {
    	this.accountField = constraintAnnotation.accountField();
    	this.typeField = constraintAnnotation.typeField();
        this.amountField = constraintAnnotation.amountField();
    }
    
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Account account = (Account) new BeanWrapperImpl(value).getPropertyValue(accountField); 
		Character type = (Character) new BeanWrapperImpl(value).getPropertyValue(typeField);
		BigDecimal amount = (BigDecimal) new BeanWrapperImpl(value).getPropertyValue(amountField);
		
		account = accountService.loadById(account.getId());
		
		if (MovementService.DEBIT_MOV.equals(type) && account.getBalance().compareTo(new BigDecimal(0)) <= 0) {
			if ((AccountService.PESO_CURRENCY.equals(account.getCurrency()) && amount.compareTo(new BigDecimal(1000)) > 0)
					|| (AccountService.DOLAR_CURRENCY.equals(account.getCurrency()) && amount.compareTo(new BigDecimal(300)) > 0)
						|| (AccountService.EURO_CURRENCY.equals(account.getCurrency()) && amount.compareTo(new BigDecimal(150)) > 0)) {
				return false;
			}
		}
		
		return true;
	}

}
