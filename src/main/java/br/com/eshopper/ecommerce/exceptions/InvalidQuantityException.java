package br.com.eshopper.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Quantida inválida.")
public class InvalidQuantityException extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidQuantityException(Integer quantity) {
		super("Quantidade inválida: " + quantity);
	}

}
