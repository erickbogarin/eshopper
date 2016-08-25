function ShoppingItemUI($shoppingItem) {

	var $quantity = $shoppingItem.find('.cart_quantity_input');
	var $price = $shoppingItem.find('.cart_total_price_value');

	var clazz = {
		update : function(shoppingItem) {
			$quantity.val(shoppingItem.quantity);
			$price.text(shoppingItem.price);
		}
	}

	return clazz;
}
