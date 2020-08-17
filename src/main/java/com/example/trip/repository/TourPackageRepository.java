package com.example.trip.repository;

import com.example.trip.model.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourPackageRepository extends CrudRepository<TourPackage,String> {

    Optional<Object> findByName(String tourPackageName);
}
