package br.com.flettieri.apicustomerservice.core.exceptions;

import java.util.Date;

public class ErrorMessage {
	
	private Date currentDate;
	private String message;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(Date currentDate, String message) {
		super();
		this.currentDate = currentDate;
		this.message = message;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	
}
