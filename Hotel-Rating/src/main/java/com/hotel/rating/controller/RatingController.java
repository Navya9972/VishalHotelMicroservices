package com.hotel.rating.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.rating.entities.Rating;
import com.hotel.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/createRating")
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
	}
	

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}
	
	
	@GetMapping("/getByHotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
}
