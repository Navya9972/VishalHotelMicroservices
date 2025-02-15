package com.userservices.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservices.entities.User;
import com.userservices.services.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServices userService;

	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user1.getId())
				.toUri();
		return ResponseEntity.created(location).body(user1);

	}

	int retryCount=1;
	// for getting a single user
	@GetMapping("/getUser/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
	//@RateLimiter(name="userHotelLimiter" , fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		logger.info("retry count :{}",retryCount);
		retryCount++;
		User user1 = userService.getUser(userId);
		return ResponseEntity.ok(user1);
	}
    //for circuit breaker
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex)
	{
		logger.info("Fallback executed...some service is down",ex.getMessage());
		User user = User.builder()
		.email("dummy@gmail.com")
		.name("dummy")
		.about("created a dummy data since the other service is down")
		.id("56742").build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
	
	// for getting all users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUser();

		return ResponseEntity.ok(users);
	}
}
