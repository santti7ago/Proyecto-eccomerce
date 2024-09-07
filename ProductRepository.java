package com.lulopet.ecommerce.application.repository;


import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.domain.User;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
}
