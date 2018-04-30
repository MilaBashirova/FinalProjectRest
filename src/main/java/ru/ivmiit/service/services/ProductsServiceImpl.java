package ru.ivmiit.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Category;
import ru.ivmiit.service.models.Product;
import ru.ivmiit.service.repositories.CategoryRepository;
import ru.ivmiit.service.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addProducts(ProductForm productForm) {
        Optional<Category> category = categoryRepository.findById(productForm.getCategory_id());
        Category category1 = category.get();
        Product product = Product.builder()
                .name(productForm.getName())
                .price(productForm.getPrice())
                .category(category1)
                .build();
        productsRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void deleteProducts(Long id) {
        productsRepository.delete(id);

    }

}
