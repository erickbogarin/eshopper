$(function () {	
	var array = $('.product-name');
	$.each(array, function(index, value) {
		var productName = $(array[index]).text();
		if(productName.length > 30)	
			$(array[index]).text($(this).text().substring(0, 30) + '...');
	});
});