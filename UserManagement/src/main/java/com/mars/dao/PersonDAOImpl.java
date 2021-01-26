package com.mars.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mars.model.Address;
import com.mars.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPerson(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);

	}
	
	public void addAddress(Person person){
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {

		return sessionFactory.getCurrentSession().createQuery("from Person")
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Address> getAllAddressForPerson(Integer personId){
		return sessionFactory.getCurrentSession().createQuery("from Address where person_id=:id").setLong("id",personId).list();
	}	

	@Override
	public void deletePerson(Integer personId) {
		Person person = (Person) sessionFactory.getCurrentSession().load(
				Person.class, personId);
		if (null != person) {
			this.sessionFactory.getCurrentSession().delete(person);
		}

	}
	
	@Override
	public void deleteAddress(Integer addressId){
		Address address = (Address) sessionFactory.getCurrentSession().load(
				Address.class, addressId);
		if (null != address) {
			this.sessionFactory.getCurrentSession().delete(address);
		}
	}
	

	public Person getPerson(int empid) {
		return (Person) sessionFactory.getCurrentSession().get(
				Person.class, empid);
	}
	
	public Address getAddress(int addressId){
		return (Address) sessionFactory.getCurrentSession().get(
				Address.class, addressId);
	}	

	@Override
	public Person updatePerson(Person person) {
		sessionFactory.getCurrentSession().update(person);
		return person;
	}
	
	@Override
	public Person updateAddress(Person person){
		sessionFactory.getCurrentSession().update(person);
		return person;
	}


}