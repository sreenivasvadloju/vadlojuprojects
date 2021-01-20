package com.mars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.dao.PersonDAO;
import com.mars.model.Address;
import com.mars.model.Person;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}
	
	@Override
	@Transactional
	public void addAddress(Person person){
		personDAO.addAddress(person);
	}
	
	@Override
	@Transactional
	public List<Person> getAllPersons() {
		return personDAO.getAllPersons();
	}
	
	@Override
	@Transactional
	public List<Address> getAllAddressForPerson(Integer personId){
		return personDAO.getAllAddressForPerson(personId);
	}

	@Override
	@Transactional
	public void deletePerson(Integer personId) {
		personDAO.deletePerson(personId);
	}
	
	@Override
	@Transactional
	public void deleteAddress(Integer addressId){
		personDAO.deleteAddress(addressId);
	}

	public Person getPerson(int empid) {
		return personDAO.getPerson(empid);
	}
	public Address getAddress(int addressId){
		return personDAO.getAddress(addressId);
	}

	public Person updatePerson(Person person) {
		// TODO Auto-generated method stub
		return personDAO.updatePerson(person);
	}
	
	public Person updateAddress(Person person){
		return personDAO.updateAddress(person);
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
