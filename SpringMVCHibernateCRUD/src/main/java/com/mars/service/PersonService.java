package com.mars.service;

import java.util.List;

import com.mars.model.Address;
import com.mars.model.Person;

public interface PersonService {
	
	public void addPerson(Person person);
	public void addAddress(Person person);

	public List<Person> getAllPersons();
	public List<Address> getAllAddressForPerson(Integer personId);
	
	public void deletePerson(Integer personId);
	public void deleteAddress(Integer addressId);

	public Person getPerson(int personid);
	public Address getAddress(int addressId);
	
	public Person updatePerson(Person person);
	public Person updateAddress(Person person);
	
	
}
