package com.lulopet.ecommerce.infrastructure.controller;

import com.lulopet.ecommerce.application.service.ProductService;
import com.lulopet.ecommerce.application.service.StockService;
import com.lulopet.ecommerce.domain.Stock;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {


    private static final String HOME_PATH = "/home";
    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    /**
     * Controlador para la página de inicio.
     */
    @GetMapping
    public String home(Model model, HttpSession httpSession) {
        model.addAttribute("products", productService.getProducts());
        handleUserIdAttribute(model, httpSession);
        return "home";
    }

    /**
     * Controlador para los detalles de un producto.
     */
    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model, HttpSession httpSession) {
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductById(id));
        log.info("Id product: {}", id);
        log.info("stock size: {}", stocks.size());
        Integer lastBalance = stocks.get(stocks.size() - 1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        handleUserIdAttribute(model, httpSession);
        return "user/productdetail";
    }

    private void handleUserIdAttribute(Model model, HttpSession httpSession) {
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        } catch (Exception e) {
            log.error("Error al obtener el ID del usuario", e);
        }
    }
}
