package br.com.eshopper.ecommerce.models;

public interface PurchaseObserver {
	
	public void execute(Purchase purchase);
}
