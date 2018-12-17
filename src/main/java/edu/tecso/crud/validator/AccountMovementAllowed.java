package edu.tecso.crud.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AccountMovementAllowedValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountMovementAllowed {
	
	String accountField();
	String typeField();
    String amountField();
 
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
    	AccountMovementAllowed[] value();
    }
    
    String message() default "invalid account movement";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

