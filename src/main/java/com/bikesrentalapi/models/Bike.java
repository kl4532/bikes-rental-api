package com.bikesrentalapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bikes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@TypeDefs({
    @TypeDef(
            name = "string-array",
            typeClass = StringArrayType.class
    )
})
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] picture;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bike", fetch = FetchType.EAGER)
    @Column(name="booked_dates")
    @OneToMany(mappedBy = "bike", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<BookedDates> bookedDates = new ArrayList<>();

    @Type( type = "string-array" )
    private String[] reviews;

    @Type( type = "string-array" )
    private String[] gear;

    private String name;
    private String description;
    private Float price;
    private String type;
    private String size;
    private String status;
    private int rating;

    public Bike() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<BookedDates> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<BookedDates> bookedDates) {
        this.bookedDates = bookedDates;
    }

    public String[] getReviews() {
        return reviews;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String[] getGear() {
        return gear;
    }

    public void setGear(String[] gear) {
        this.gear = gear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
