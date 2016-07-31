function ShoppingCartUI() {
	var $subTotal = $('.total_area').find('.price-subtotal');
	var $total = $('.total_area').find('.price-total');
	
	var clazz = {
		setSubTotal : function(subTotal) {
			$subTotal.text(subTotal);
		},
		getTotal : function() {
			return $total;
		},
		setTotal : function(total) {
			$total.text(total);
		},
		getFreight: function() {
			return parseFloat($('.price-freight').text());
		},
		getShoppingCart : function() {
			return new ShoppingCart(
					parseFloat($subTotal.text()), 
					parseFloat($total.text())
				);
		},
		evaluateFreight: function() {
			var shoppingCart = this.getShoppingCart();
			
			var total = shoppingCart.estimateFreight(this.getFreight());
			this.setTotal(total.toFixed(2));
		}
	}

	return clazz;

}