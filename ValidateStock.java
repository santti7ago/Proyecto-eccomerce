package com.lulopet.ecommerce.application.service;

import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.domain.Stock;

import java.util.List;
public class ValidateStock {
    private final StockService stockService;

    // Constructor para inyectar StockService
    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }

    // Verifica si hay un balance existente para un producto
    private boolean existBalance(Product product) {
        List<Stock> stockList = stockService.getStockByProduct(product);
        return !stockList.isEmpty();
    }

    // Calcula el balance de Stock
    public Stock calculateBalance(Stock stock) {
        if (stock.getUnitIn() != 0) {
            // Si hay una entrada de unidades
            if (existBalance(stock.getProduct())) {
                // Si hay un balance existente, se suma al balance existente
                List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
                Integer balance = stockList.get(stockList.size() - 1).getBalance();
                stock.setBalance(balance + stock.getUnitIn());
            } else {
                // Si no hay un balance existente, el balance es igual a las unidades de entrada
                stock.setBalance(stock.getUnitIn());
            }
        } else {
            // Si hay una salida de unidades, se resta del balance existente
            List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance - stock.getUnitOut());
        }
        return stock;
    }
}
