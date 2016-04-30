package br.com.eshopper.ecommerce.models;

import java.math.BigDecimal;

/**
 * Created by Erick on 03/04/2016.
 */

public class CartDto {

    private Integer quantityItem;
    private Integer quantityTotal;
    private BigDecimal priceItem;
    private BigDecimal priceSubTotal;
    private BigDecimal priceTotal;

    public CartDto() {
    }

    public CartDto quantityItem(Integer quantityItem) {
        this.quantityItem = quantityItem;
        return this;
    }

    public CartDto quantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
        return this;
    }

    public CartDto priceItem(BigDecimal priceItem) {
        this.priceItem = priceItem;
        return this;
    }

    public CartDto priceSubTotal(BigDecimal priceTotal) {
        this.priceSubTotal = priceTotal;
        return this;
    }
    
    public CartDto priceTotal(BigDecimal priceTotal) {
    	this.priceTotal = priceTotal;
    	return this;
    }
    
    public Integer getQuantity() {
        return quantityItem;
    }

    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public BigDecimal getPriceItem() {
        return priceItem;
    }

    public BigDecimal getPriceSubTotal() {
        return priceSubTotal;
    }
    
    public BigDecimal getPriceTotal() {
		return priceTotal;
	}
    
}
