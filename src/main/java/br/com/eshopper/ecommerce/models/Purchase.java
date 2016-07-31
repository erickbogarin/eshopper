package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Purchase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(scale = 2)
	private BigDecimal price;
	 
	@Min(1)
	private Integer productsQuantity;
	
	@DateTimeFormat(iso=ISO.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm a z")
	private Calendar purchaseDate;
	
	@Enumerated(EnumType.STRING)
	private PurchaseStatus purchaseStatus;
	
	@ManyToOne
	private SystemUser user;
	
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private List<Sale> sales = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Calendar getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getProductsQuantity() {
		return productsQuantity;
	}
	public void setProductsQuantity(Integer productsQuantity) {
		this.productsQuantity = productsQuantity;
	}
	
	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	
	public void addSale(Sale sale) {
		sale.setPurchase(this);
		this.sales.add(sale);
	}
	
	public List<Sale> getSales() {
		return sales;
	}
	
	public SystemUser getUser() {
		return user;
	}
	public void setUser(SystemUser user) {
		this.user = user;
	}
	
	public void chargeFreight(BigDecimal freight) {
		this.price = this.price.add(freight); 
	}
	
	@Override
	public String toString() {
		return "Purchase [price=" + price + ", purchaseDate=" + purchaseDate +  "]";
	}
	
}
