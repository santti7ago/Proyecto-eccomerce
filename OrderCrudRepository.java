package com.lulopet.ecommerce.infrastructure.adapter;

import com.lulopet.ecommerce.infrastructure.entity.OrderEntity;
import com.lulopet.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity , Integer> {
    public Iterable<OrderEntity> findByUser(UserEntity userEntity);
}
