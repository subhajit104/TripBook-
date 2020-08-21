package com.example.trip.business.controller;

import com.example.trip.business.dto.RatingDto;
import com.example.trip.business.dto.TourRatingDto;
import com.example.trip.model.Tour;
import com.example.trip.model.TourRating;
import com.example.trip.model.TourRatingPk;
import com.example.trip.repository.TourRatingRepository;
import com.example.trip.repository.TourRepository;
import com.example.trip.service.TourRatingService;
import com.example.trip.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "tours/{tourId}/ratings")
public class TourRatingController {

     private TourRatingService tourRatingService;
     private TourService tourService;

     @Autowired
     TourRatingRepository tourRatingRepository;
     @Autowired
     TourRepository tourRepository;

     @Autowired
    public TourRatingController(TourRatingService tourRatingService, TourService tourService) {
        this.tourRatingService = tourRatingService;
        this.tourService = tourService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TourRating createRating(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) throws Exception {
         verifyTour(tourId);
         Tour tour = verifyTour(tourId);
         tourRatingService
                 .save(new TourRating(new TourRatingPk(tour,ratingDto.getCustomerId()),ratingDto.getScore(),ratingDto.getComment()));
         return tourRatingRepository.findById(new TourRatingPk(tour,ratingDto.getCustomerId())).get();
    }

    /**
     *
     * @param tourId tour identifier.
     * @retrun tourRatingDto have average rating for that studio.
     */
    @GetMapping("/average")
    @ResponseStatus(HttpStatus.OK)
    public TourRatingDto getRatingForTour(@PathVariable(value = "tourId") int tourId) {
        Tour tour = verifyTour(tourId);
        List<TourRating> tourRatings = tourRatingRepository.findByPkTourId(tourId);
        int numberOfRatings = tourRatings.size();
        if(numberOfRatings == 0 ) throw  new NoSuchElementException("No ratings there");
        float score = 0.0f;
        TourRatingDto tourRatingDto = new TourRatingDto();
        for (TourRating tourRating : tourRatings) {
            score = score + (float) tourRating.getScore();
            tourRatingDto.addComment(tourRating.getComment());
        }
        tourRatingDto.setTourTitle(tour.getTitle());
        tourRatingDto.setAverageRating(score/numberOfRatings);
        tourRatingDto.setTourDescription(tour.getDescription());
        return tourRatingDto;
    }

    /**
     * Delete a Rating of a tour made by a customer
     * @param tourId tour identifier
     * @param customerId customer identifier
     */
    @DeleteMapping(path = "/{customerId}")
    public void delete(@PathVariable(value = "tourId") int tourId, @PathVariable(value = "customerId") int customerId) {
        TourRating rating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(rating);
    }

    /**
     * Verify and return the TourRating for a particular tourId and Customer
     * @param tourId tour identifier
     * @param customerId customer identifier
     * @return the found TourRating
     * @throws NoSuchElementException if no TourRating found
     */
    private TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {
        return tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId, customerId).orElseThrow(() ->
                new NoSuchElementException("Tour-Rating pair for request("
                        + tourId + " for customer" + customerId));
    }

    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId tour identifier
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("Tour does not exist " + tourId));
    }

    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex exception
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }
}
