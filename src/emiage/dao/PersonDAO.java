package emiage.dao;

import java.util.List;

import emiage.entity.Person;

public interface PersonDAO {

	public List<Person> getPersons();

	public void savePerson(Person thePerson);

	public Person getPerson(int theId);

	public void deletePerson(int theId);
	
}
