package com.ankit.rs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ankit.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("person")
public class PersonResource {
	
	@GET
	@Produces("application/json")
	public String getAllPersons(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("IntuitRS");
	    EntityManager em = factory.createEntityManager();
		String returnString=null;
		//Person personlist = em.find(Person.class, 1);
		List<Person> personlist = (List<Person>)em.createNamedQuery("Person.findAll", Person.class).getResultList();
		ObjectMapper mapper = new ObjectMapper();
		try {
			returnString = mapper.writeValueAsString(personlist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String getPersonById(@PathParam("id")int id){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("IntuitRS");
	    EntityManager em = factory.createEntityManager();
		String returnString=null;
		em.getTransaction().begin();
		Person personlist = em.find(Person.class, id); 
		//List<Person> personlist = (List<Person>)em.createNamedQuery("Person.findAll", Person.class).getResultList();
		ObjectMapper mapper = new ObjectMapper();
		try {
			returnString = mapper.writeValueAsString(personlist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.getTransaction().rollback();
		em.close();
		return returnString;
	}
	
	@POST
	@Produces("application/json")
	public String addEmployee(@FormParam("name") String name, @FormParam("dob")String dob, 
			@FormParam("sex")String sex, @FormParam("email") String email){
		String returnString = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("IntuitRS");
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Person person = new Person();
	    person.setName(name);
	    try {
			person.setDob(new SimpleDateFormat("yyyy-mm-dd").parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    person.setSex(sex);
	    person.setEmail(email);
	    em.persist(person);
	    em.getTransaction().commit();
	    //em.refresh(person);
	    em.close();
	    ObjectMapper mapper = new ObjectMapper();
		try {
			returnString = mapper.writeValueAsString(person);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return returnString;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public String deleteEmployee(@PathParam("id") String id){
		String returnString = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("IntuitRS");
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Person person = em.find(Person.class, Integer.parseInt(id)); 
	    em.remove(person);
	    em.getTransaction().commit();
	    //em.refresh(person);
	    em.close();
	    ObjectMapper mapper = new ObjectMapper();
		try {
			returnString = mapper.writeValueAsString(person);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return returnString;
		
	}

}
