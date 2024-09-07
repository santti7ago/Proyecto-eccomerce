package com.lulopet.ecommerce.application.repository;

import com.lulopet.ecommerce.domain.Order;
import com.lulopet.ecommerce.domain.User;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable<Order> getOrdersByUser(User user);
}

