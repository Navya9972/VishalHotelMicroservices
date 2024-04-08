package com.hotel.rating.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.rating.entities.Rating;
import com.hotel.rating.repositories.RatingRepository;
import com.hotel.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating create(Rating rating) {
		return ratingRepo.save(rating);
	}
	
	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}
	
	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
