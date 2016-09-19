function FreightMessageUI($content) {
	
	var $deadline = $content.find('.deadline');
	var $error = $content.find('.msgError');
	
	var clazz = {
		update: function(freightMessage) {
			$deadline.text(freightMessage.deadline);
			$error.text(freightMessage.msgError);
		}
	}
	
	return clazz;
	
}