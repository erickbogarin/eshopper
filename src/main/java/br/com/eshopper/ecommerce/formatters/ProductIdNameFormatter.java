package br.com.eshopper.ecommerce.formatters;

import java.text.Normalizer;

public class ProductIdNameFormatter {
	
	public static String format(String unformatted) {
		unformatted = unformatted.replaceAll("\\s+", "-").toLowerCase();
		return Normalizer.normalize(unformatted, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]|\\.", "");
	}
	
}
