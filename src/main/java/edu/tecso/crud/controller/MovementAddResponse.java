package edu.tecso.crud.controller;

import edu.tecso.crud.model.Movement;

public class MovementAddResponse {
	
	private boolean success;
	
	private String error;
	
	private Movement movementAdded;
	
	public MovementAddResponse(boolean success, String error, Movement movementAdded) {
		super();
		this.success = success;
		this.error = error;
		this.movementAdded = movementAdded;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Movement getMovementAdded() {
		return movementAdded;
	}

	public void setMovementAdded(Movement movementAdded) {
		this.movementAdded = movementAdded;
	}

}
