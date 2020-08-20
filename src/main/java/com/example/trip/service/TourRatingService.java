package com.example.trip.service;

import com.example.trip.repository.TourRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TourRatingService {

    private final TourRatingRepository tourRatingRepository;

    @Autowired
    public TourRatingService(TourRatingRepository tourRatingRepository) {
        this.tourRatingRepository = tourRatingRepository;
    }

}
