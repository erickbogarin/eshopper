package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Sale implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Min(1)
	private Integer quantity;
	 
	@Column(scale = 2)
	private BigDecimal total;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	@JsonBackReference
	private Purchase purchase;
	
	public Sale() {
	}
	
	public Sale(Integer quantity, BigDecimal total, Product product) {
		this.quantity = quantity;
		this.total = total;
		this.product = product;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", quantity=" + quantity + ", total=" + total + ", product=" + product + ", purchase="
				+ purchase + "]";
	}
	
}
