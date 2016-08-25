function CorreiosService(row) {
	
	var httpService = new HttpService();
	
	var clazz = {
		calculate : function(params) {
			params.path = 'v1/correios/calculate';
			return httpService.post(params);
		}
	};
	
	return clazz;
}
