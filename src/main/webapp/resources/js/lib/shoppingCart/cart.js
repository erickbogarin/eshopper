/**
 * Created by Erick on 04/04/2016.
 */
$(function () {	
	$shoppingCart = $('body').find('.shopping-cart');
    $subTotal = $('body').find('.price-subtotal');
    $total = $('body').find('.price-total');
    window.freight = 0;
    
    var changeCartQuantityButton = function (event) {
    	
        event.preventDefault();

        var data = {
        		item: $(this).closest('.cart_body'), 
        		url: event.data.url
        };
        changeCartQuantityAjax(data);
    }
    
    var changeCartQuantityInput = function(event) {
    	
    	event.preventDefault();

    	var data = {
    		item: $(this).closest('.cart_body'),
    		quantity: $(this).val(),
    		url: event.data.url
    	};
    	changeCartQuantityAjax(data);
    } 
    
    var correriosCalculation = function(event) {
    	
    	event.preventDefault();
    	
    	var row = $(this).closest('.row');
    	correiosCalculationAjax(row);
    }
    
    var checkEmptyInputCep = function() {
    	if( $(this).val().length == 0 ) {
    		var row = $(this).closest('.row');
        	correiosCalculationAjax(row);
    	}
    }
    
    $('.cart_quantity_up').click({
    		url: serverContext + 'v1/shopping/increaseItem'
    	}, changeCartQuantityButton);
    
    $('.cart_quantity_down').click({
    		url: serverContext + 'v1/shopping/decreaseItem'
    	}, changeCartQuantityButton);
    
    $('.cart_quantity_input').on( 'change blur' , {
    		url: serverContext + 'v1/shopping/changeItemQuantity' 
    	}, changeCartQuantityInput);

    $('.cep-calculation').click(correriosCalculation);
    $('.cep-input').blur(checkEmptyInputCep);
});