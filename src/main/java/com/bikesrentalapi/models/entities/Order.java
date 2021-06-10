package com.bikesrentalapi.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="items")
    private List<Item> items;
    @Column(name="user")
    private User user;
}
