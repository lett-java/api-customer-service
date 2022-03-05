package br.com.flettieri.apicustomerservice.core.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request) {
		String errorDescription = exception.getLocalizedMessage();
		
		if (errorDescription == null) {
			errorDescription = exception.toString();
		}
		
		return new ResponseEntity<>(
				new ErrorMessage(new Date(), errorDescription), 
				new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
