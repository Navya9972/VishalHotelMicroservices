package com.userservices.entities;



import java.util.ArrayList;

import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="micro_user")
@Entity
@Builder
public class User {
	
    @Id	
    private String id;
    private String name;
    private String email;
    private String about;
    private String password;

    @ElementCollection
    private java.util.List<Rating> ratings = new ArrayList<>();
    
}

