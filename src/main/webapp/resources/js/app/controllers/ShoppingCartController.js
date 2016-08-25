/* ShoppingCart Controller */

$(function() {
	
	var shoppingCartUI = new ShoppingCartUI();
	var shoppingCartService = new ShoppingCartService();
	var correiosService = new CorreiosService();
	
	var updateShoppingCart = function(event) {

		event.preventDefault();
		
		var self = $(this);
		var selectedShoppingItem =  self.closest('.cart_body');		

		var loadingState = selectedShoppingItem.find('.loading');
		var shoppingItemUI = new ShoppingItemUI(selectedShoppingItem);
		
		var params = {
			productId: selectedShoppingItem.find('.item_id').val(),
			quantity : self.val() || '',			
		};
		
		loadingState.show();
		$.when(event.data.callback(params))
			.then(function( response, textStatus, jqXHR ) {

				var shoppingCart = new ShoppingCart(response.priceSubTotal);
				shoppingCartUI.update(shoppingCart);
				
				var shoppingItem = new ShoppingItem(response.quantity, response.priceItem);
				shoppingItemUI.update(shoppingItem);
			})
			.always(function() {
				loadingState.hide();
			});
	};
	
	var calculateCep = function(event) {
		
		event.preventDefault();
		
		if ($(this).val().length == 0) {
			
			var $resume = $(this).closest('.cep-area');
			var freightMessageUI = new FreightMessageUI($resume);
			var loadingState = $resume.find('.loading');
			
			var params = {
				cep: $resume.find('.cep-input').val(),
			};
			
			loadingState.show();
			$.when(correiosService.calculate(params))
				.then(function( response, textStatus, jqXHR ) {
					
					freightMessageUI.update(response);
					shoppingCartUI.setFreight(response.freight);
				})				
				.always(function() {
					loadingState.hide();
				});
		}
	};
	
	/* ***********
	  User Events
	**************/
	
	/* Shopping Item */
	$('.cart_quantity_up').click({
		callback : function(params) {
			return shoppingCartService.increaseItem(params);
		}	
	}, updateShoppingCart);
	$('.cart_quantity_down').click({
		callback : function(params) {
			return shoppingCartService.decreaseItem(params);
		}
	}, updateShoppingCart);
	$('.cart_quantity_input').on('change blur', {
		callback : function(params) {
			return shoppingCartService.changeItemQuantity(params);
		}
	}, updateShoppingCart);
	
	/* Freight */
	$('.cep-calculation').click(calculateCep);
	$('.cep-input').blur(calculateCep);

});
