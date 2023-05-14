package com.sanjeev.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeev.binding.Person;
import com.sanjeev.service.PhoneBookService;

@RestController
public class PhoneBookingRestController {
	
	@Autowired
	private PhoneBookService phoneService;
	
	@PostMapping("/person")
	public ResponseEntity<String> createContact(@RequestBody Person person){
		String status = phoneService.upsert(person);
		return  new ResponseEntity<>(status, HttpStatus.CREATED);	
	}
	 
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> viewContact(@PathVariable Integer id){
		Person person = phoneService.getById(id);
		return new ResponseEntity<>(person , HttpStatus.OK);
		
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllContacts(){
		List<Person> allCallDetails = phoneService.getAllCallDetails();
		return new ResponseEntity<>(allCallDetails , HttpStatus.OK);
	}
	
	@PutMapping("/person")
	public ResponseEntity<String> updateContact(@RequestBody Person person){
		String status = phoneService.upsert(person);
		return new ResponseEntity<> (status,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer id){
		
		String status = phoneService.deleteById(id);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
	

}
