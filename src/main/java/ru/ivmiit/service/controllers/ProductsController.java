package ru.ivmiit.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Product;
import ru.ivmiit.service.services.ProductsService;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/addProducts")
    public String Products() {
        return "addProducts";
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Object> addProduct(@RequestBody ProductForm productForm) {
        productsService.addProducts(productForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productsService.findAllProducts();
    }

    @DeleteMapping("/products/{product-id}")
    public void getProduct(@PathVariable("product-id") Long productsId) {

        productsService.deleteProducts(productsId);
    }


}
