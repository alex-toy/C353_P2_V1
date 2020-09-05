package emiage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import emiage.entity.Property;

@Repository
public class PropertyDAOImpl implements PropertyDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Property> getProperties() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Property> theQuery = currentSession.createQuery("from Property order by surface", Property.class);
		List<Property> properties = theQuery.getResultList();
		return properties;
	}

	@Override
	public void saveProperty(Property theProperty) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProperty);
		
	}

	@Override
	public Property getProperty(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Property theProperty = currentSession.get(Property.class, theId);
		return theProperty;
	}

	@Override
	public void deleteProperty(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Property where id=:propertyId");
		theQuery.setParameter("propertyId", theId);
		theQuery.executeUpdate();		
	}

}











