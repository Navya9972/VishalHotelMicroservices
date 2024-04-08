package com.userservices.services;

import java.util.List;



import com.userservices.entities.User;


public interface UserServices {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	
}
