var changeCartQuantityAjax = function(dataTarget) {
	var productId = dataTarget.item.find('.item_id').val();
	var quantity = dataTarget.quantity;
	var url = dataTarget.url;
	
	var quantityItem = dataTarget.item.find('.cart_quantity_input');
    var priceItem = dataTarget.item.find('.cart_total_price_value');
	
	var loadingState = dataTarget.item.find('.loading');
	$.ajax({
		method : 'GET',
		url : url,
		data : {
			productId : productId,
			quantity: quantity
		},
		beforeSend : function() {
			loadingState.show();
		},
		success : function(data) {
			loadingState.hide();
			
			quantityItem.val(data.quantity);
			priceItem.text(data.priceItem);
			
			shoppingCartUI.setSubTotal(data.priceSubTotal);
			shoppingCartUI.setTotal(data.priceTotal);
			shoppingCartUI.evaluateFreight();
		}
	});
}