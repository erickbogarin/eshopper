package br.com.eshopper.ecommerce.supports;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eshopper.ecommerce.daos.BrandDAO;
import br.com.eshopper.ecommerce.models.Brand;

@Component
public class BrandEditor extends PropertyEditorSupport{
	
	@Autowired
	private BrandDAO brandDAO;
	
	@Override
	public void setAsText(String id)  {
		Brand brand = brandDAO.find(Integer.valueOf(id));
		this.setValue(brand);
	}
	
}
