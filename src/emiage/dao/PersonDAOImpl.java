package emiage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emiage.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Person> getPersons() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Person> theQuery = currentSession.createQuery("from Person order by lastName", Person.class);
		List<Person> persons = theQuery.getResultList();
		return persons;
	}

	@Override
	public void savePerson(Person thePerson) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thePerson);
		
	}

	@Override
	public Person getPerson(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Person thePerson = currentSession.get(Person.class, theId);
		return thePerson;
	}

	@Override
	public void deletePerson(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Person where id=:personId");
		theQuery.setParameter("personId", theId);
		theQuery.executeUpdate();		
	}

}











