package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataException extends RuntimeException{

	 public DataException(String message) {

		    super(message);

		  }
}
