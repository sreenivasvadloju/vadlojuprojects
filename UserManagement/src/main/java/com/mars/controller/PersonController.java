package com.mars.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mars.exceptionhandler.RecordNotFoundException;
import com.mars.model.Address;
import com.mars.model.Person;
import com.mars.service.PersonService;

/**
 * This is the Controller class manages the Create/Read/Update/Delete function
 * 
 * @author Sreenivas Vadloju
 *
 */
@RequestMapping(value="/usermanagement")
@Controller
public class PersonController {

	private static final Logger logger = Logger.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;


	/**
	 * Fetches the list of persons.
	 * 
	 * @param model
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/home")
	@ExceptionHandler(RecordNotFoundException.class)
	public ModelAndView getAllPersons(ModelAndView model) throws IOException {
		List<Person> personList = personService.getAllPersons();
		model.addObject("personList", personList);
		model.setViewName("home");
		return model;
	}
	
	/**
	 * Redirects the user to add a new person.
	 * @param model
	 * @return model
	 */
	@RequestMapping(value = "/newPerson", method = RequestMethod.GET)
	public ModelAndView newPerson(ModelAndView model) {
		Person person = new Person();
		model.addObject("person", person);
		model.setViewName("addPerson");
		return model;
	}
	
	/**
	 * This method saves Person details into database. 
	 * @param person
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute @Valid Person person,BindingResult result) {
		
		 if(result.hasErrors()) {
	    	    return new ModelAndView("addPerson");
	        }
		
		if (person.getId() == 0) { // if person id is 0 then creating the
			// person other updating the person
			personService.addPerson(person);
		} else {
			personService.updatePerson(person);
		}
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	/**
	 * This method deletes Person details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView deletePerson(HttpServletRequest request) {
		long personId = Long.parseLong(request.getParameter("id"));
		personService.deletePerson(personId);
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	/**
	 * This method redirects the user to edit the Person details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editPerson", method = RequestMethod.GET)
	public ModelAndView editPerson(HttpServletRequest request) {
		long personId = Long.parseLong(request.getParameter("id"));
		Optional<Person> person = personService.getPerson(personId);
		ModelAndView model = new ModelAndView("addPerson");
		model.addObject("person", person);
		return model;
	}
	
	/**
	 * This method Person and Address details.
	 * @param model
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/viewPersonAddress", method = RequestMethod.GET)
	public ModelAndView viewPersonAddress(ModelAndView model,HttpServletRequest request) {
		long personId = Long.parseLong(request.getParameter("id"));
		//Get all Address related to a person.
		List<Address> listAddress = personService.getAllAddressForPerson(personId);
		model.addObject("listAddress", listAddress);		
		Optional<Person> person1 = personService.getPerson(personId);
		Person person = person1.get();
		model.setViewName("personDetails");
		model.addObject("person", person);
		return model;
	}
	
	/**
	 * This method add new address. 
	 * @param model
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	public ModelAndView addAddress(ModelAndView model,HttpServletRequest request) {
		long personId = Long.parseLong(request.getParameter("id"));
		Optional<Person> person1 = personService.getPerson(personId);
	
		Person person = person1.get();
		Address address = new Address();
		address.setPerson(person);
		model.addObject("address", address);
		model.addObject("person", person);
		model.setViewName("addAddress");
		return model;
	}
	
	/**
	 * This method saves Address details. 
	 * @param address
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public ModelAndView saveAddress(@ModelAttribute @Valid Address address,BindingResult result) {
		 if(result.hasErrors()) {
	    	    return new ModelAndView("addAddress");
	     }
		long personId = address.getPerson().getId();
		Optional<Person> person1 = personService.getPerson(personId);
		Person person = person1.get();
		Set<Address> addressSet=new HashSet<Address>();
		addressSet.add(address);
		person.setAddressList(addressSet);
		
		if (address.getId() == 0) { 
			personService.addAddress(person);
		} else {
			personService.updateAddress(person);
		}
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	/**
	 * This method redirects the user to edit the Address details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public ModelAndView editAddress(HttpServletRequest request) {
		int addressId = Integer.parseInt(request.getParameter("id"));
		Optional<Address> address1= personService.getAddress(addressId);
		Address address = address1.get();
		ModelAndView model = new ModelAndView("addAddress");
		model.addObject("address", address);
		return model;
	}
	
	/**
	 * This method deletes Address details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public ModelAndView deleteAddress(HttpServletRequest request) {
		int addressId = Integer.parseInt(request.getParameter("id"));
		personService.deleteAddress(addressId);
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	
	
	

}