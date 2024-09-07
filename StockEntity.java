package com.lulopet.ecommerce.infrastructure.entity;

import com.lulopet.ecommerce.domain.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@Data
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    @ManyToOne //Muchos a uno
    @OnDelete(action = OnDeleteAction.CASCADE)//Nos inidica como debemos gestionar cuando la entidad padre sea eliminada
    private ProductEntity productEntity;
}
