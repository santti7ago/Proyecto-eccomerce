package com.lulopet.ecommerce.infrastructure.controller;

import com.lulopet.ecommerce.application.service.ProductService;
import com.lulopet.ecommerce.domain.Product;
import com.lulopet.ecommerce.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }

    @PostMapping("/save-product")
    public String saveProduct(Product product, @RequestParam("img") MultipartFile multipartFile, HttpSession httpSession ) throws IOException {
        log.info("Nombre de producto: {}", product);
        productService.saveProduct(product, multipartFile, httpSession);
        //return "admin/products/create";
        return "redirect:/admin";
    }

    /**
     *  Recibe un objeto Model como parámetro. Crea un objeto User, establece su ID en 1 y
     *  luego obtiene una lista de productos asociados a este usuario utilizando el servicio productService.
     * @param model
     * @return
     */
    @GetMapping("/show")
    public String showProduct(Model model, HttpSession httpSession){
        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());
        User user = new User();
        user.setId(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }

    /**
     * Recibe el ID del producto como una variable de ruta (id) y un objeto Model.
     * Utiliza el servicio productService para obtener el producto asociado a ese ID. Luego,
     * loguea información sobre el producto obtenido y lo agrega al modelo con la clave "product".
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product",product);
        return "admin/products/edit";
    }

    /**
     * Utiliza el servicio productService para eliminar el producto asociado a ese ID y
     * luego redirige a la página de visualización de productos ("/admin/products/show").
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin/products/show";
    }


}
