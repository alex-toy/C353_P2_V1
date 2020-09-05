package emiage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import emiage.dao.PersonDAO;
import emiage.entity.Person;




@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	@Transactional
	public List<Person> getPersons() {
		return personDAO.getPersons();
	}

	@Override
	@Transactional
	public void savePerson(Person thePerson) {

		personDAO.savePerson(thePerson);
	}

	@Override
	@Transactional
	public Person getPerson(int theId) {
		
		return personDAO.getPerson(theId);
	}

	@Override
	@Transactional
	public void deletePerson(int theId) {
		
		personDAO.deletePerson(theId);
	}
}





