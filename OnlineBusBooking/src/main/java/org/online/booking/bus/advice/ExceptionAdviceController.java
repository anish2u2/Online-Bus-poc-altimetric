package org.online.booking.bus.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceController {

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> returnErrorResponse() {
		Map<String, String> message = new HashMap<String, String>();
		message.put("statusCode", "500");
		message.put("message", "Unable to process your request at this point.");
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

}
