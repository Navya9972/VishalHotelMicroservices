package com.hotel.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.service.entities.Hotel;

@Service
public interface HotelService {


	List<Hotel> getAll();
	Hotel create(Hotel hotel);
	Hotel get(String id);
	void delete(String id);
}
