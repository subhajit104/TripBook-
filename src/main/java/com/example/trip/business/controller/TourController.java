package com.example.trip.business.controller;
import com.example.trip.model.Tour;
import com.example.trip.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {

    private  final TourRepository tourRepository;

    @Autowired
    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Iterable<Tour> getTours(){
        return tourRepository.findAll();
    }
}
