package com.userservices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.userservices.entities.Rating;
import com.userservices.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(4).id("").hotelId("").feedback("Created using test class").build();
		Rating savedRating = ratingService.createRating(rating);
		System.out.println("New rating created");
	}

}
