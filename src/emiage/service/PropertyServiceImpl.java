package emiage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import emiage.dao.PropertyDAO;
import emiage.entity.Property;



@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDAO propertyDAO;
	
	@Override
	@Transactional
	public List<Property> getProperties() {
		return propertyDAO.getProperties();
	}

	@Override
	@Transactional
	public void saveProperty(Property theProperty) {

		propertyDAO.saveProperty(theProperty);
	}

	@Override
	@Transactional
	public Property getProperty(int theId) {
		
		return propertyDAO.getProperty(theId);
	}

	@Override
	@Transactional
	public void deleteProperty(int theId) {
		
		propertyDAO.deleteProperty(theId);
	}
}





