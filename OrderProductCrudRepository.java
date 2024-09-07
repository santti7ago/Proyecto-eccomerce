package com.lulopet.ecommerce.infrastructure.adapter;

import com.lulopet.ecommerce.infrastructure.entity.OrderEntity;
import com.lulopet.ecommerce.infrastructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

// Interfaz que extiende CrudRepository para operaciones CRUD en OrderProductEntity
public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer> {

    // Método para buscar OrderProductEntity por la entidad OrderEntity asociada
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);
}
