package com.lulopet.ecommerce.infrastructure.mapper;

import com.lulopet.ecommerce.domain.OrderProduct;
import com.lulopet.ecommerce.infrastructure.entity.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

public interface OrderProductMapper {

    @Mappings(
            {
                    @Mapping(source = "pk.productEntity", target = "product"),
                    @Mapping(source = "quantity", target = "quantity"),
                    @Mapping(source = "pk.orderEntity", target = "order"),
            }
    )
        // Método para mapear de OrderProductEntity a OrderProduct
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);

    // Método para mapear de Iterable<OrderProductEntity> a Iterable<OrderProduct>
    Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> orderProductEntities);

    // Método para mapear de Iterable<OrderProductEntity> a List<OrderProduct>
    List<OrderProduct> toOrderProductsList(Iterable<OrderProductEntity> orderProductEntities);

    // InheritInverseConfiguration indica que la inversión del mapeo se hereda de otro método
    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);
}
