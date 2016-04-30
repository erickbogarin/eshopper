package br.com.eshopper.ecommerce.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EmptyJsonResponse {
	
	public String getResult() {
		return "empty";
	}
	
}
