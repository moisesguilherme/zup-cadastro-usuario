package com.zup.cadastro.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ResourceExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		// Código 422 (Não foi processado corretamente essa entidade)
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

		StandardError err = new StandardError();

		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Validation exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());

		for (FieldError fe : e.getBindingResult().getFieldErrors()) {
			err.getErrors().put(fe.getField(), fe.getDefaultMessage());
		}

		return ResponseEntity.status(status).body(err);
	}
}
