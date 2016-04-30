var changeCartQuantityAjax = function(dataTarget) {
	var productId = dataTarget.item.find('.item_id').val();
	var quantity = dataTarget.quantity;
	
	var quantityItem = dataTarget.item.find('.cart_quantity_input');
    var priceItem = dataTarget.item.find('.cart_total_price_value');
	
	var loadingState = dataTarget.item.find('.loading');
	$.ajax({
		method : 'GET',
		url : dataTarget.url,
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
			$shoppingCart.text(data.quantityTotal);
	        $subTotal.text(data.priceSubTotal);
	        $total.text(data.priceTotal + window.freight);
		}
	});
}

var correiosCalculationAjax = function(row) {
	
	var cep = row.find('.cep-input').val();
	var freight = row.find('.price-freight');
	var priceSubTotal = row.find('.price-subtotal');
	var priceTotal = row.find('.price-total');
	var deadline = row.find('.deadline');
	
	var loadingState = row.find('.loading');
	$.ajax({
		method: 'GET',
		url: serverContext + 'v1/correios/calculate',
		data: {
			cep: cep
		},
		beforeSend : function() {
			loadingState.show();
		},
		success: function(data) {
			loadingState.hide();
			
			freight.text(data.freight);
			priceTotal.text(parseFloat(priceSubTotal.text()) + parseFloat(freight.text()));
			deadline.text(data.deadline);
			row.find('.msgError').text(data.msgError);
		}
	});
	
}
