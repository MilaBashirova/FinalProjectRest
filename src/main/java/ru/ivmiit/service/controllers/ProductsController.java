package ru.ivmiit.service.controllers;

import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Product;
import ru.ivmiit.service.services.ProductsService;
import ru.ivmiit.service.transfer.ProductDto;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping("/addProducts")
    public Product addProduct(@RequestBody ProductForm productForm) {
        return productsService.addProducts(productForm);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productsService.findAllProducts();
    }

    @GetMapping("/products/name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productsService.findProductsByName(name);
    }

    @DeleteMapping("/products/{product-id}")
    public void deleteProduct(@PathVariable("product-id") Long productsId) {
        productsService.deleteProducts(productsId);
    }

    @PostMapping("/products/updateProduct")
    public Product updateDescriptionProduct(@RequestBody ProductDto productDto){
        return productsService.updateDescriptionProduct(productDto);
    }
}
