package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	}
	
	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String>DeleteByHotelId(@PathVariable String id)
	{
		 hotelService.delete(id);
		 return ResponseEntity.ok("Hotel with ID " + id + " deleted successfully");
	}
	
	
}
