package com.example.trip.business.controller;
import com.example.trip.model.Tour;
import com.example.trip.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tours")
public class TourController {

    private TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public Iterable<Tour> getTours(){
        return tourService.findAll();
    }

    @GetMapping("/{tourId}")
    public Tour getTourById(@PathVariable(value = "tourId") int tourId) {

        Optional<Tour> tour  = tourService.getTourById(tourId);
        if(tour.isEmpty()) {
            return null;
        } else {
            return tour.get();
        }
    }

}
