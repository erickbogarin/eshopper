var correiosCalculationAjax = function(row) {
	
	var cep = row.find('.cep-input').val();
	var freight = row.find('.price-freight');
	var priceSubTotal = row.find('.price-subtotal');
	var priceTotal = row.find('.price-total');
	var deadline = row.find('.deadline');
	
	var loadingState = row.find('.loading');
	$.ajax({
		method: 'GET',
		url: urlPath + 'v1/correios/calculate',
		data: {
			cep: cep
		},
		beforeSend : function() {
			loadingState.show();
		},
		success: function(data) {
			loadingState.hide();
			
			freight.text(data.freight);
			deadline.text(data.deadline);
			row.find('.msgError').text(data.msgError);
			
			var subTotal = parseFloat(priceSubTotal.text());
			var freight = parseFloat(freight.text());
			priceTotal.text(subTotal  + freight );
		}
	});
	
}
