package br.com.eshopper.ecommerce.models;

import java.io.Serializable;

public interface DomainObject extends Serializable {

	String getKey();

	String getObjectKey();

}
