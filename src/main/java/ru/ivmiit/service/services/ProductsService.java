package ru.ivmiit.service.services;

import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Product;
import ru.ivmiit.service.transfer.ProductDto;

import java.util.List;

public interface ProductsService {
    Product addProducts(ProductForm productForm);

    List<Product> findAllProducts();

    void deleteProducts(Long id);

    List<Product> findProductsByName(String name);

    Product updateDescriptionProduct(ProductDto productDto);
}
