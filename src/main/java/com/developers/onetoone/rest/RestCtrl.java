package com.developers.onetoone.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developers.onetoone.entity.Person;
import com.developers.onetoone.repository.PersonRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestCtrl {

	private Logger logger = LoggerFactory.getLogger(RestCtrl.class);

	@Autowired
	private PersonRepo personRepo;

	@GetMapping("/welcome")
	public String welcome() {
		logger.info(
				"******  ******  ****** ******  RestCtrl method Welcome execution starts   ******  ******  ****** ******  ");

		return "hello welcome rest controller";
	}

	@PostMapping("/person-data")
	public String person(@RequestBody Person p) {

		logger.info(
				"******  ******  ****** ******  RestCtrl.person() execution starts   ******  ******  ****** ******  ");
		System.out.println(p);
		logger.info("******  ******  ****** ****** save data to db execution starts   ******  ******  ****** ******  ");
		Person save = personRepo.save(p);
		logger.info(
				"******  ******  ****** ****** save data to db execution ends   ******  ******  ****** ******  dta saved is :: "
						+ save);
		return "data successfully saved to database";
	}

	@GetMapping("/person-data")
	public ResponseEntity<List<Person>> persons() {
		logger.info(
				"******  ******  ****** ******  RestCtrl method persons execution starts   ******  ******  ****** ******  ");
		List<Person> personList = personRepo.findAll();

		logger.info(
				"******  ******  ****** ******  RestCtrl method persons fetched data    ******  ******  ****** ******  personList:: "
						+ personList);

		return new ResponseEntity<>(personList, HttpStatus.OK);
	}

	@DeleteMapping("/person-data/{id}")
	public ResponseEntity<List<Person>> deletePerson(@PathVariable Integer id) {
		logger.info(
				"******  ******  ****** ******  RestCtrl method deletePerson execution starts   ******  ******  ****** ******  ");
		personRepo.deleteById(id);
		System.out.println("data deleted");
		List<Person> personList = personRepo.findAll();
		logger.info(
				"******  ******  ****** ******  RestCtrl method deletePerson data deleted    ******  ******  ****** ****** personList ::"
						+ personList);

		return new ResponseEntity<>(personList, HttpStatus.OK);
	}

	@DeleteMapping("/person-data")
	public ResponseEntity<List<Person>> deletePersonByRequestParam(@RequestParam("id") Integer id) {
		logger.info(
				"******  ******  ****** ******  RestCtrl method deletePersonByRequestParam :: execution starts   ******  ******  ****** ******  ");
		System.out.println("execution startd id : " + id);
		personRepo.deleteById(id);
		System.out.println("data deleted");
		List<Person> personList = personRepo.findAll();
		logger.info(
				"******  ******  ****** ******  RestCtrl method deletePersonByRequestParam :: data deleted    ******  ******  ****** ****** personList ::"
						+ personList);

		return new ResponseEntity<>(personList, HttpStatus.OK);
	}
}
