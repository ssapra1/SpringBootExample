package com.principal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.principal.DaoImpl.PersonDao;
import com.principal.Exception.ListNotFoundException;
import com.principal.Exception.MissingHeaderInfoException;
import com.principal.model.Person;

@RestController
@RequestMapping("/application")

public class WelcomeController {

	@Autowired
	PersonDao persondao;
	
	@Autowired
	SessionFactory sessionfactory;
	// inject via application.properties
	List<Person> list = new ArrayList<Person>();

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addusers", method = RequestMethod.POST)
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	public String addUser(@RequestBody String Name, String Salary) {

		Person person = new Person();
		person = new Person(Name, Salary);
		System.out.println("session factor is "+sessionfactory);
System.out.println("Name is"+Name);
		list = persondao.addUser(person);
		sessionfactory.getCurrentSession().save(person);
		JSONObject json = new JSONObject();
		for (Person list1 : list) {
			json.put("name", list1.getName());
			json.put("Salary", list1.getSalary());

		}

		return json.toString();
	}

	@GET
	@RequestMapping("/users")
	@Transactional
	public ResponseEntity<?> getAllUsers(Map<String, Object> model) throws ListNotFoundException, MissingHeaderInfoException {
		Criteria cr=sessionfactory.getCurrentSession().createCriteria(Person.class);
		List<Person> personList=cr.list();
		
		JSONObject json = new JSONObject();
		json.put("personlist", personList);
		
		return new ResponseEntity<Object>(json,HttpStatus.OK);
		

		
	}

	@GET
	@GetMapping("/getPerson/{Id}")
	@Transactional
	public Response getPersonByName(@PathVariable Integer Id) {
		 Query query = sessionfactory.getCurrentSession().createQuery("SELECT e.Name FROM Person e WHERE e.Id=:Id");
		 
		 query.setParameter("Id", Id);
		 System.out.println(query.uniqueResult());
		JSONObject json = new JSONObject();

		
		json.put("key", query.uniqueResult());

		return Response.ok(json, MediaType.APPLICATION_JSON).build();

	}

/*public Response getPerson()
{
	return ResponseEntity<"string","rees",HttpStatus.OK>;
	
}*/

}
