function ShoppingCartService() {
	
	var httpService = new HttpService();
	
	var clazz = {
		
		increaseItem: function(params) {
			params.path = 'v1/shopping/increaseItem';
			return httpService.post(params);
		},
		decreaseItem: function(params) {
			params.path = 'v1/shopping/decreaseItem';			
			return httpService.post(params);
		},
		changeItemQuantity: function(params) {
			params.path = 'v1/shopping/changeItemQuantity';			
			return httpService.post(params);
		}		
	}

	return clazz;
}