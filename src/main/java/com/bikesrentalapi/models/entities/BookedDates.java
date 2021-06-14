package com.bikesrentalapi.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "booked_dates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookedDates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_start")
    private String dateStart;

    @Column(name="date_end")
    private String dateEnd;

    @ManyToOne
    @JoinColumn(name = "bike_id")
    @JsonIgnore
    private Bike bike;

    @Column(name="bike_id", insertable = false, updatable = false)
    private Long bikeId;

    public BookedDates() {}

    public Long getBikeId() {
        return bikeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
