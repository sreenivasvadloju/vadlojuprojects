package com.mars.service;

import java.util.List;
import java.util.Optional;

import com.mars.model.Address;
import com.mars.model.Person;

public interface PersonService {
	

	public List<Person> getAllPersons();
	public Person addPerson(Person person);
	public Person updatePerson(Person person);	
	public void deletePerson(long personId);
	public Optional<Person> getPerson(long personid);	
	public List<Address> getAllAddressForPerson(long personId);
	
	public void addAddress(Person person);
	public Person updateAddress(Person person);
	
	public Optional<Address> getAddress(long addressId);
	
	public void deleteAddress(long addressId);
	
}
