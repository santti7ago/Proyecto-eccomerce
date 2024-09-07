package com.lulopet.ecommerce.infrastructure.adapter;

import com.lulopet.ecommerce.application.repository.StockRepository;
import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.domain.Stock;
import com.lulopet.ecommerce.infrastructure.mapper.ProductMapper;
import com.lulopet.ecommerce.infrastructure.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepositoryImpl implements StockRepository {

    // Repositorio de CRUD específico para Stock
    private final StockCrudRepository stockCrudRepository;

    // Mapper para convertir entre objetos Stock y entidades Stock
    private final StockMapper stockMapper;

    // Mapper para convertir entre objetos Product y entidades Product
    private final ProductMapper productMapper;

    // Constructor para inyectar dependencias
    public StockRepositoryImpl(StockCrudRepository stockCrudRepository, StockMapper stockMapper, ProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
    }
    // Método para guardar un Stock
    @Override
    public Stock saveStock(Stock stock) {
        // Convierte el objeto Stock a su representación de entidad y lo guarda en la base de datos
        return stockMapper.toStock(stockCrudRepository.save(stockMapper.toStockEntity(stock)));
    }

    // Método para obtener una lista de Stock por un producto
    @Override
    public List<Stock> getStockByProduct(Product product) {
        // Obtiene la lista de entidades de Stock relacionadas con el producto dado y las convierte a objetos Stock
        return stockMapper.toStocks(stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)));
    }
}

