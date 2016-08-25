function HttpService() {
	
	var url = $('#urlPath').val();
	
	var clazz = {
		post: function(params) {
			return $.ajax({
				method : 'POST',
				url : url + params.path,
				data : params
			});
		}	
	};
	
	return clazz;
}