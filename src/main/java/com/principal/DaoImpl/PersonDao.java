package com.principal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.principal.model.Person;


@Service

public class PersonDao {

	List<Person> list=new ArrayList<Person>();
	public List<Person> addUser(Person person)
	{
		list.add(person);
		return list;
	}
	public List<Person> getUsersList()
	{
		return list;
	}
}
