package com.bikesrentalapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "booked_dates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookedDates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booked_date_id;
    private String dateStart;
    private String dateEnd;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "bikes_booked_dates",
            joinColumns = @JoinColumn(name = "bike_id"),
            inverseJoinColumns = @JoinColumn(name = "booked_date_id"))
    @JsonIgnore
    private Bike bike;

    public BookedDates() {}

    public Long getBooked_date_id() {
        return booked_date_id;
    }

    public void setBooked_date_id(Long booked_date_id) {
        this.booked_date_id = booked_date_id;
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
