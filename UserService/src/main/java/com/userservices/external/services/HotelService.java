package com.userservices.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservices.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE-APPLICATION")
public interface HotelService {

	@GetMapping("/hotels/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
