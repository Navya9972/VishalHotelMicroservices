package com.userservices.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Rating {
    private String ratingId;
    private String id;
    private String hotelId;
    private int rating;
    private String feedback;
    @Transient
    private Hotel hotel;
}
