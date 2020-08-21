package com.example.trip.business.dto;

import java.util.ArrayList;
import java.util.List;

public class TourRatingDto {

    private String tourTitle;
    private String tourDescription;
    private float averageRating;
    private List<String> comments;

    public TourRatingDto() {
        comments = new ArrayList<>();
    }

    public void addComment(String comment){
        comments.add(comment);
    }
    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public TourRatingDto setAverageRating(float averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
