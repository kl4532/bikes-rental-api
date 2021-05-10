package com.bikesrentalapi.models;

import java.util.List;

public class Bike {
    private String id;
    private String name;
    private String description;
    private Float price;
    private String type;
    private String size;
    private List<BookedDates> bookedDates;
    private List<String> reviews;
    private Number rating;
    private List<String> gear;
    private String status;
//    private Blob picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<BookedDates> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<BookedDates> bookedDates) {
        this.bookedDates = bookedDates;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public Number getRating() {
        return rating;
    }

    public void setRating(Number rating) {
        this.rating = rating;
    }

    public List<String> getGear() {
        return gear;
    }

    public void setGear(List<String> gear) {
        this.gear = gear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
