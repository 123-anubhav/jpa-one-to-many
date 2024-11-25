package com.developers.onetomany.rest.bidirectional;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developers.onetomany.entity.bidirectional.AddressBidirectional;
import com.developers.onetomany.entity.bidirectional.UserBidirectional;
import com.developers.onetomany.repository.bidirectional.IAddressRepoBidirectional;
import com.developers.onetomany.repository.bidirectional.IUserRepoBidirectional;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestCtrlOneToManyBidirectional {

	private Logger logger = LoggerFactory.getLogger(RestCtrlOneToManyBidirectional.class);

	@Autowired
	private IUserRepoBidirectional userRepo;

	@Autowired
	private IAddressRepoBidirectional addrRepo;
	
	@PostMapping("/user-bidirectional")
	public String saveUser(@RequestBody UserBidirectional user) {
	    logger.info("RestControllerOneToMany.saveUser() execution starts");

	    // Set the user reference in each address
	    if (user.getAddr() != null) {
	        for (AddressBidirectional address : user.getAddr()) {
	            address.setUser(user);
	        }
	    }

	    UserBidirectional savedUser = userRepo.save(user);
	    logger.info("Data saved with user ID: {}", savedUser.getUserId());
	    return "Data saved with ID: " + savedUser.getUserId();
	}

	@GetMapping("/users-bidirectional")
	public List<UserBidirectional> getUsers() {
	    logger.info("Fetching all users with addresses");
	    return userRepo.findAll();
	}

	@GetMapping("/user-bidirectional/{userId}")
	public ResponseEntity<UserBidirectional> getUserById(@PathVariable Integer userId) {
	    logger.info("Fetching user with ID: {}", userId);

	    // Fetch user from the repository
	    Optional<UserBidirectional> userOptional = userRepo.findById(userId);

	    // Check if user exists
	    if (userOptional.isPresent()) {
	        logger.info("User found: {}", userOptional.get());
	        return ResponseEntity.ok(userOptional.get());
	    } else {
	        logger.warn("User with ID {} not found", userId);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}

}
