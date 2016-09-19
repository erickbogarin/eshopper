function ShoppingCartUI() {
	var $subTotal = $('.total_area').find('.price-subtotal');
	var $total = $('.total_area').find('.price-total');
	var $freight = $('.price-freight');
	
	var clazz = {
		_setSubTotal : function(subTotal) {
			$subTotal.text(subTotal);
			this._evaluateFreight();
		},
		getTotal : function() {
			return $total;
		},
		_setTotal : function(total) {
			$total.text(total);
		},
		setFreight: function(value) {
			$freight.text(value);
			this._evaluateFreight();
		},
		getFreight: function() {
			return parseFloat($freight.text());
		},
		_createShoppingCart : function() {
			return new ShoppingCart(
					parseFloat($subTotal.text())					
				);
		},
		_evaluateFreight: function() {
			var shoppingCart = this._createShoppingCart();
	
			var total = shoppingCart.setTotal(this.getFreight());
			this._setTotal(total.toFixed(1));
		},
		update: function(shoppingCart) {			
			this._setSubTotal(shoppingCart.subTotal);
		}
	}
	
	window.onload = clazz._evaluateFreight();
	
	return clazz;
}