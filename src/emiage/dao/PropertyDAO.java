package emiage.dao;

import java.util.List;

import emiage.entity.Property;

public interface PropertyDAO {

	public List<Property> getProperties();

	public void saveProperty(Property theProperty);

	public Property getProperty(int theId);

	public void deleteProperty(int theId);
	
}
