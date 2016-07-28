function removeParam(parameter) {
	var url = document.location.href;
	var urlparts = url.split('?');

	if (urlparts.length >= 2) {
		var urlBase = urlparts.shift();
		var queryString = urlparts.join("?");

		var prefix = encodeURIComponent(parameter) + '=';
		var pars = queryString.split(/[&;]/g);
		for (var i = pars.length; i-- > 0;)
			if (pars[i].lastIndexOf(prefix, 0) !== -1)
				pars.splice(i, 1);
		url = urlBase + pars.join('&');
		window.history.pushState('', document.title, url);

	}
	return url;
}

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

var locale = getCookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
if (locale == "pt" || locale == "") {
	$('#firstLanguage').append('Português <span class="caret"></span>');
	$('#secondLanguage').attr('href', '?locale=en_US');
	$('#secondLanguage').append('English');
} else {
	$('#firstLanguage').append('English <span class="caret"></span>');
	$('#secondLanguage').attr('href', '?locale=pt');
	$('#secondLanguage').append('Português');
}
removeParam('locale');
