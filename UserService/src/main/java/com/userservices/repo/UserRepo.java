package com.userservices.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.userservices.entities.User;


public interface UserRepo extends JpaRepository<User, String>{
	public Optional<User> findById(String id);
}
