package br.com.eshopper.ecommerce.supports;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eshopper.ecommerce.daos.CategoryDAO;
import br.com.eshopper.ecommerce.models.Category;

@Component
public class CategoryEditor extends PropertyEditorSupport{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public void setAsText(String id)  {
		Category category = categoryDAO.find(Integer.valueOf(id));
		this.setValue(category);
	}
	
}
