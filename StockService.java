package com.lulopet.ecommerce.application.service;

import com.lulopet.ecommerce.application.repository.StockRepository;
import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.domain.Stock;

import java.util.List;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public Stock saveStock(Stock stock){
        return stockRepository.saveStock(stock);
    }
    public List<Stock> getStockByProduct(Product product){
        return stockRepository.getStockByProduct(product);
    }
}
