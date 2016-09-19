function ShoppingCart(subTotal, total) {

	var clazz = {
		subTotal : subTotal,
		setTotal : function(freight) {
			return (freight > 0) ? (subTotal + freight) : subTotal;
		}
	}

	return clazz;
}