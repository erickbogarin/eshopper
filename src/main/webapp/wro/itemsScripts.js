serverContext=$("#serverContext").val();
var changeCartQuantityAjax=function(a){var b=a.item.find(".item_id").val(),c=a.quantity,e=a.item.find(".cart_quantity_input"),f=a.item.find(".cart_total_price_value"),d=a.item.find(".loading");$.ajax({method:"GET",url:a.url,data:{productId:b,quantity:c},beforeSend:function(){d.show()},success:function(a){d.hide();e.val(a.quantity);f.text(a.priceItem);$shoppingCart.text(a.quantityTotal);$subTotal.text(a.priceSubTotal);$total.text(a.priceTotal+window.freight)}})},correiosCalculationAjax=function(a){var b=
a.find(".cep-input").val(),c=a.find(".price-freight"),e=a.find(".price-subtotal"),f=a.find(".price-total"),d=a.find(".deadline"),g=a.find(".loading");$.ajax({method:"GET",url:serverContext+"v1/correios/calculate",data:{cep:b},beforeSend:function(){g.show()},success:function(b){g.hide();c.text(b.freight);f.text(parseFloat(e.text())+parseFloat(c.text()));d.text(b.deadline);a.find(".msgError").text(b.msgError)}})};
$(function(){$shoppingCart=$("body").find(".shopping-cart");$subTotal=$("body").find(".price-subtotal");$total=$("body").find(".price-total");window.freight=0;var b=function(a){a.preventDefault();a={item:$(this).closest(".cart_body"),url:a.data.url};changeCartQuantityAjax(a)};$(".cart_quantity_up").click({url:serverContext+"v1/shopping/increaseItem"},b);$(".cart_quantity_down").click({url:serverContext+"v1/shopping/decreaseItem"},b);$(".cart_quantity_input").on("change blur",{url:serverContext+"v1/shopping/changeItemQuantity"},
function(a){a.preventDefault();a={item:$(this).closest(".cart_body"),quantity:$(this).val(),url:a.data.url};changeCartQuantityAjax(a)});$(".cep-calculation").click(function(a){a.preventDefault();a=$(this).closest(".row");correiosCalculationAjax(a)});$(".cep-input").blur(function(){if(0==$(this).val().length){var a=$(this).closest(".row");correiosCalculationAjax(a)}})});
