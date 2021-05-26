package com.bikesrentalapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
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
    private Long bike_id;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] picture;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bike", fetch = FetchType.EAGER)
    private List<BookedDates> bookedDates;

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

    public Long getBike_id() {
        return bike_id;
    }

    public void setBike_id(Long bike_id) {
        this.bike_id = bike_id;
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
