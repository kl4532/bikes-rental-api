package com.bikesrentalapi.services;

import com.bikesrentalapi.models.OrderRaw;
import com.bikesrentalapi.models.entities.BookedDates;
import com.bikesrentalapi.models.entities.Order;
import com.bikesrentalapi.models.entities.User;
import com.bikesrentalapi.repositories.OrderRepository;
import com.bikesrentalapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public Order createOrder(OrderRaw rawOrder) {
        Order order = new Order();
        User user = rawOrder.getUser();
        List<BookedDates> bd = rawOrder.getBookedDates();
        order.setBookedDates(bd);

        if (user.getId() > 0) {
            order.setUserId(user.getId());
        } else {
            User newUser = this.userService.createUser(user);
            order.setUserId(newUser.getId());
        }

        return orderRepository.saveAndFlush(order);
    }
}
