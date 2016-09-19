package br.com.eshopper.ecommerce.models;

public enum CategoryType {
	ROUPAS("Roupas"), 
	CALCADOS("Calçados"), 
	ACESSORIOS("Acessórios");
	
	private String category;
	
	CategoryType(String category) {
		this.category = category;
	}
	
	public String getName() {
		return category;
	}
	
	@Override
	public String toString() {
		return category;
	}
	
}
