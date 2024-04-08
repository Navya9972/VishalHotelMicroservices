package com.userservices.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.userservices.entities.Rating;

@FeignClient(name ="HOTEL-RATING-APPLICATION")
public interface RatingService {

	@PostMapping("/ratings/createRating")
	public Rating createRating(Rating ratings);
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable("ratingId") String ratingId , Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
	
	
}
