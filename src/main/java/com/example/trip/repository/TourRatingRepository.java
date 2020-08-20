package com.example.trip.repository;

import com.example.trip.model.TourRating;
import com.example.trip.model.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRatingRepository extends CrudRepository<TourRating,TourRatingPk> {

}
