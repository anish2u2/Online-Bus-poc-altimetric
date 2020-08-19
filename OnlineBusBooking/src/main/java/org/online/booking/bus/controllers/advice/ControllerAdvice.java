package org.online.booking.bus.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> sendError(Throwable t){
		t.printStackTrace();
		return new ResponseEntity<String>("Error while processing your request",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
