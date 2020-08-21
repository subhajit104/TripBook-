package com.example.trip.service;

import com.example.trip.model.TourRating;
import com.example.trip.repository.TourRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourRatingService {

    private final TourRatingRepository tourRatingRepository;

    @Autowired
    public TourRatingService(TourRatingRepository tourRatingRepository) {
        this.tourRatingRepository = tourRatingRepository;
    }

    public void save(TourRating tourRating){
        tourRatingRepository.save(tourRating);
    }


}
