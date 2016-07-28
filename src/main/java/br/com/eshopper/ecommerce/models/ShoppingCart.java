package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private CorreiosDto correios;
    
    private Map<ShoppingItem, Integer> items = new LinkedHashMap<ShoppingItem, Integer>();

    public void add(ShoppingItem item) {
        items.put(item, getQuantity(item) + 1);
    }
    
    public Integer getQuantity(ShoppingItem item) {
        if (!items.containsKey(item)) {
            items.put(item, 0);
        }
        return items.get(item);
    }
    
    public void decreaseItem(ShoppingItem item) {
    	if(getQuantity(item) > 1) items.put(item, getQuantity(item) - 1);
    }
    
    public void changeQuantity(ShoppingItem item, Integer quantity) {
    	if(quantity >= 1) items.replace(item, getQuantity(item), quantity);
	}

    public Integer getQuantity() {
        return items.values().stream().reduce(0, (next, accumulator) -> next + accumulator);
    }

    public BigDecimal getTotal(ShoppingItem item) {
        return item.getTotal(getQuantity(item));
    }
    
    public BigDecimal getTotal() {
    	if(correios.getFreight() != BigDecimal.ZERO) { return getSubTotal().add(correios.getFreight()); }
    	return getSubTotal();
    }
    
    public BigDecimal getSubTotal() {
        BigDecimal total = BigDecimal.ZERO;
        // TODO change to reduce?
        for (ShoppingItem item : items.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }

    public void remove(ShoppingItem shoppingItem) {
        correios.clear();
    	items.remove(shoppingItem);
    }

    public Collection<ShoppingItem> getList() {
        return items.keySet();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }

	public void clear() {
		correios.clear();
		items.clear();
	}

}	
