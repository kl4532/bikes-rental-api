package com.bikesrentalapi.models;

import com.bikesrentalapi.models.entities.BookedDates;
import com.bikesrentalapi.models.entities.User;

import java.util.List;

public class OrderRaw {
    private List<BookedDates> bookedDates;
    private User user;

    public List<BookedDates> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<BookedDates> bookedDates) {
        this.bookedDates = bookedDates;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
