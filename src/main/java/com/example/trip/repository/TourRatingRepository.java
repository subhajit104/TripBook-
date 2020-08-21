package com.example.trip.repository;

import com.example.trip.model.TourRating;
import com.example.trip.model.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourRatingRepository extends CrudRepository<TourRating,TourRatingPk> {

       List<TourRating> findByPkTourId(Integer tourId);
       Optional<TourRating> findByPkTourIdAndPkCustomerId(int tourId, int customerId);
}
