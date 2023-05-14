package com.sanjeev.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeev.binding.Person;


public interface PhoneBookRepository  extends JpaRepository<Person, Serializable>{

}
