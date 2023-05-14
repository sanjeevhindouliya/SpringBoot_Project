package com.sanjeev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjeev.binding.Person;
import com.sanjeev.repo.PhoneBookRepository;


@Service
public class PhoneBookingServiceImpl implements PhoneBookService {

	@Autowired
	private PhoneBookRepository phoneRepo;
	
	@Override
	public String upsert(Person person) {
		phoneRepo.save(person);
		return "success"; // upsert means insert and update record based on Pk
	}

	@Override
	public Person getById(Integer id) {
		Optional<Person> findById = phoneRepo.findById(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

	@Override
	public List<Person> getAllCallDetails() {
		return phoneRepo.findAll();
		
	}

	@Override
	public String deleteById(Integer id) {
		if(phoneRepo.existsById(id)) {
			phoneRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}

}
