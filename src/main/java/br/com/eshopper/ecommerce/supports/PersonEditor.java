package br.com.eshopper.ecommerce.supports;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eshopper.ecommerce.daos.PersonDAO;
import br.com.eshopper.ecommerce.models.Person;

@Component
public class PersonEditor extends PropertyEditorSupport{
	
	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public void setAsText(String id) {
		Person person = personDAO.find(Integer.valueOf(id));
		this.setValue(person);
	}
	
}
