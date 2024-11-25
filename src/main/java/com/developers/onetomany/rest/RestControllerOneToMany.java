package com.developers.onetomany.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developers.onetomany.entity.Address;
import com.developers.onetomany.entity.User;
import com.developers.onetomany.repository.IAddressRepo;
import com.developers.onetomany.repository.IUserRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestControllerOneToMany {

	private Logger logger = LoggerFactory.getLogger(RestControllerOneToMany.class);

	@Autowired
	private IUserRepo userRepo;

	@Autowired
	private IAddressRepo addrRepo;

	@PostMapping("/user")
	public String user(@RequestBody User user) {
		logger.info(
				"******  ******  ****** ******  RestControllerOneToMany.user() execution starts   ******  ******  ****** ******  ");
		System.out.println("user data is :: " + user);
		// this approach is wrong
				
		/*
		 * if (user.getAddr() != null) { user.getAddr().forEach(address ->
		 * address.setUser(user)); }
		 */

		logger.info("******  ******  ****** ****** save data to db execution starts   ******  ******  ****** ******  ");
		User save = userRepo.save(user);
		logger.info(
				"******  ******  ****** ****** save data to db execution ends   ******  ******  ****** ******  data saved at id "
						+ save.getUserId());
		return "data saved with id :: " + save.getUserId();
	}

	@GetMapping("/users")
	public List<User> users() {
		logger.info("RestControllerOneToMany.users( ) method execute starts for fetch user information");
		List<User> listOfUsers = userRepo.findAll();
		System.out.println("RestControllerOneToMany.users():: listOfUsers :: " + listOfUsers);
		logger.info("RestControllerOneToMany.users( ) method execute ends fetched info successfully data are ::"
				+ listOfUsers);
		return listOfUsers;
	}

	// @Transactional
	@GetMapping("/user/{userId}")
	public User usersData(@PathVariable("userId") Integer userId) {
		logger.info("RestControllerOneToMany.usersData( ) method execute starts for fetch user information");
		User user = userRepo.findById(userId).orElse(null);

		System.out.println("RestControllerOneToMany.usersData():: user data is :: " + user);
		try {
			if (!user.getName().isEmpty()) {
				logger.info(
						"RestControllerOneToMany.usersData( ) method execute ends fetched info successfully data is ::"
								+ user);
				return user;
			}
			logger.info("RestControllerOneToMany.usersData( ) method execute ends unable to fetch data");
		} catch (Exception e) {
			logger.error("RestControllerOneToMany.usersData( )  error occurs ::" + e);
			e.printStackTrace();
		}
		return null;
	}

}
