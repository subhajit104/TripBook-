package com.example.trip.repository;

import com.example.trip.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends PagingAndSortingRepository<Tour,Integer> {
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
    Iterable<Tour> findAll();
}
