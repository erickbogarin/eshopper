package br.com.eshopper.ecommerce.models;

public enum BrandType {
	ADIDAS("Adidas"), 
	CALVIN_KLEIN("Calvin Klein"), 
	LACOSTE("Lacoste"), 
	NIKE("Nike"),
	PUMA("Puma"),
	RESERVA("Reserva"),
	TOMMY_HILFIGER("Tommy Hilfiger");
	
	private String brand;
	
	BrandType(String brand) {
		this.brand = brand;
	}
	
	public String getName() {
		return brand;
	}
	
	@Override
	public String toString() {
		return brand;
	}
	
}
