package br.com.meta.prova.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(code = HttpStatus.CONFLICT)
@Getter
public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor empty
	 * 
	 * @param message
	 */
	public ValidationException(String exceptionMsg) {
		super(exceptionMsg);
	}

	public ValidationException(String message, Exception exception) {
		super(message, exception);
	}
}