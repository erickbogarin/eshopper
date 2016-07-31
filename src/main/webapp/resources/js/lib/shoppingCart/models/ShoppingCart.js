function ShoppingCart(subTotal, total) {
	
	var clazz = {
			subTotal : subTotal,
			total : total,
			estimateFreight : function(freight) {
				if (freight > 0) {
					return total + freight;
				}
				return total;
			}
	}
	
	return clazz;
}