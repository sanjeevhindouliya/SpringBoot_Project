package com.sanjeev.service;

import java.util.List;

import com.sanjeev.binding.Person;

public interface PhoneBookService {
	
	public String upsert(Person person);
	
	public Person getById(Integer id);
	
	public List<Person> getAllCallDetails();
	
	public String deleteById(Integer id);
	

}
