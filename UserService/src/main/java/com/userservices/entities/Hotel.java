package com.userservices.entities;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
//@embeddable means it doesnot create a new  table for this entity class)
public class Hotel {

	private String id;
	private String name;
	private String location;
	private String about;
	
}