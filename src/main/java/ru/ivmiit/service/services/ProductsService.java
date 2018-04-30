package ru.ivmiit.service.services;

import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Product;

import java.util.List;

public interface ProductsService {
    void addProducts(ProductForm productForm);

    List<Product> findAllProducts();

    void deleteProducts(Long id);
}
