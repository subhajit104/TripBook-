package com.example.trip.repository;

import com.example.trip.model.TourRating;
import com.example.trip.model.TourRatingPk;
import org.springframework.data.repository.CrudRepository;

public interface TourRatingRepository extends CrudRepository<TourRatingPk, TourRating> {

}
