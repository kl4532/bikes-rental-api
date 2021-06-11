package com.bikesrentalapi.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="booked_dates")
    @OneToMany(mappedBy = "bike", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<BookedDates> bookedDates = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<BookedDates> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<BookedDates> bookedDates) {
        this.bookedDates = bookedDates;
    }
}
