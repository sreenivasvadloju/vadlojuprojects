package com.mars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.dao.PersonDAO;
import com.mars.model.Address;
import com.mars.model.Person;
import com.mars.repository.AddressRepository;
import com.mars.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	
	 @Override
	 public List<Person> getAllPersons() {
	  return (List<Person>) personRepository.findAll();
	 }
	 
	 @Override
	 @Transactional
	 public Person addPerson(Person person) {
		 return personRepository.save(person);
	 }
	 @Override
	 @Transactional
	 public Person updatePerson(Person person) { // TODO Auto-generated method
		return personRepository.save(person); 
	 }
	
	 @Override
	 @Transactional
	 public void deletePerson(long personId) {
		 personRepository.deleteById(personId);
	 }
	 

	 public Optional<Person> getPerson(long personId) {
		 return personRepository.findById(personId);		
	 }
	 
	
	 @Override
	 @Transactional
	 public List<Address> getAllAddressForPerson(long personId){
		 return addressRepository.findByPersonId(personId); 
	 }
		 
	@Override
	@Transactional	
	public void addAddress(Person person){
		personRepository.save(person);
	}
	
	@Override
	@Transactional
	public Person updateAddress(Person person){
		return personRepository.save(person);
	}
	
	public Optional<Address> getAddress(long addressId) {
		 return addressRepository.findById(addressId); 		
	}
	
	@Override
	public void deleteAddress(long addressId){
		addressRepository.deleteById(addressId);
	}
	
	 
		/*
		 * @Override
		 * 
		 * @Transactional public List<Address> getAllAddressForPerson(Integer personId){
		 * return personRepository.getAllAddressForPerson(personId); }
		 */
	 
	 
		/*
		 * @Override
		 * 
		 * @Transactional public void addPerson(Person person) {
		 * personRepository.save(person); }
		 * 
		 * @Override
		 * 
		 * @Transactional public void addAddress(Person person){
		 * personRepository.save(person); }
		 */
	 
	 
		/*
		 * 
		 * @Override
		 * 
		 * @Transactional public List<Address> getAllAddressForPerson(Integer personId){
		 * return personRepository.getAllAddressForPerson(personId); }
		 * 
		 * @Override
		 * 
		 * @Transactional public void deletePerson(Long personId) {
		 * personRepository.deleteById(personId); }
		 * 
		 * @Override
		 * 
		 * @Transactional public void deleteAddress(Long addressId){
		 * personRepository.deleteById(addressId); }
		 * 
		 * public Person getPerson(int empid) { return
		 * personRepository.getPerson(empid); } public Address getAddress(int
		 * addressId){ return personRepository.getAddress(addressId); }
		 * 
		 * public Person updatePerson(Person person) { // TODO Auto-generated method
		 * stub return personRepository.updatePerson(person); }
		 * 
		 * public Person updateAddress(Person person){ return
		 * personRepository.updateAddress(person); }
		 * 
		 * public void setPersonDAO(PersonDAO personDAO) { this.personRepository =
		 * personDAO; }
		 */
}
