package com.lulopet.ecommerce.application.repository;

import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.domain.Stock;

import java.util.List;

public interface StockRepository {
    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
