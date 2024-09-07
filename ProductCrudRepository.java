package com.lulopet.ecommerce.infrastructure.adapter;

import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.infrastructure.entity.ProductEntity;
import com.lulopet.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository  extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity (UserEntity userEntity);
}
