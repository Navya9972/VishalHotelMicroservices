package com.userservices.services.Imp;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.userservices.entities.Hotel;
import com.userservices.entities.Rating;
import com.userservices.entities.User;
import com.userservices.exceptions.ResourceNotFoundException;
import com.userservices.external.services.HotelService;
import com.userservices.repo.UserRepo;
import com.userservices.services.UserServices;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserRepo userrpo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//for feign client
	@Autowired
	private HotelService hotelservice;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setId(randomUserId);
		return userrpo.save(user);
		}

	
	@Override
	public List<User> getAllUser() {
		return userrpo.findAll();
	}
	
	
 //using RestTemplate
	@Override
	public User getUser(String userId) {
		User user = userrpo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given ID does not exist id:!!" + userId));
		Rating[] ratingsList = restTemplate.getForObject("http://HOTEL-RATING-APPLICATION/ratings/getByUserId/"+ user.getId(), Rating[].class);
		List<Rating> ratings =  Arrays.stream(ratingsList).toList();
		user.setRatings(ratings);
		System.out.println(ratings);
		
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			//api call to get hotel service 
			// set the hotel to rating
			//return the rating
			ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTEL-SERVICE-APPLICATION/hotels/getHotel/"+ rating.getHotelId(),Hotel.class);
			//Hotel hotel = hotelservice.getHotel(rating.getHotelId());
			Hotel hotel1 = hotel.getBody();
			rating.setHotel(hotel1);
			return rating;
		}).collect(Collectors.toList());
		
		
		return user;
	}
	
	
//	//using Feign client
//	public User getUser1(String userId) {
//		User user = userrpo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given ID does not exist id:!!" + userId));
//		Rating[] ratingsList = restTemplate.getForObject("http://HOTEL-RATING-APPLICATION/ratings/getByUserId/"+ user.getId(), Rating[].class);
//		List<Rating> ratings =  Arrays.stream(ratingsList).toList();
//		user.setRatings(ratings);
//		System.out.println(ratings);
//		
//		
//		List<Rating> ratingList = ratings.stream().map(rating -> {
//			//api call to get hotel service 
//			// set the hotel to rating
//			//return the rating
//			Hotel hotel = hotelservice.getHotel(rating.getHotelId());
//			rating.setHotel(hotel);
//			return rating;
//		}).collect(Collectors.toList());
//		
//		
//		return user;
//	}
	

}
