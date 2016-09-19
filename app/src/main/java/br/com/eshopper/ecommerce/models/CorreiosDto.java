package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class CorreiosDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String cep;
	private BigDecimal freight = BigDecimal.ZERO;;
	private String deadline;
	private String msgError;
	
	public CorreiosDto() {
	}

	public CorreiosDto cep(String cep) {
		this.cep = cep;
		return this;
	}
	
	public CorreiosDto freight(String freight) {
		this.freight = new BigDecimal(freight.replace(',', '.'));
		return this;
	}
	
	public CorreiosDto deadline(String deadline) {
		if(getMsgError().isEmpty())
			this.deadline = "Prazo de entrega: " + deadline + " dias úteis (após aprovação do pagamento)";
		else this.deadline = "";
		return this;
	}
	
	public CorreiosDto msgError(String msgError) {
		this.msgError = msgError;
		return this;
	}
	
	public String getCep() {
		return cep;
	}
	
	public BigDecimal getFreight() {
		return freight;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public String getMsgError() {
		return msgError;
	}

	public void clear() {
		this.cep = "";
		this.freight = BigDecimal.ZERO;
		this.deadline = "";
		this.msgError = "";
	}
	
}
