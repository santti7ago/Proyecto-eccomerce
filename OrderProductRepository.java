package com.lulopet.ecommerce.application.repository;

import com.lulopet.ecommerce.domain.Order;
import com.lulopet.ecommerce.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create (OrderProduct orderProduct);
    public Iterable<OrderProduct>  getOrderProducts();
    public List<OrderProduct> getOrdersProductByOrder(Order order);
}
