package ru.ivmiit.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Category;
import ru.ivmiit.service.models.Product;
import ru.ivmiit.service.repositories.CategoryRepository;
import ru.ivmiit.service.repositories.ProductsRepository;
import ru.ivmiit.service.transfer.ProductDto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product addProducts(ProductForm productForm) {
        Optional<Category> category = categoryRepository.findById(productForm.getCategory_id());
        Category category1 = category.get();
        Product product = Product.builder()
                .name(productForm.getName())
                .price(productForm.getPrice())
                .category(category1)
                .build();
        Product result=productsRepository.save(product);
        return result;
    }

    @Override
    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void deleteProducts(Long id) {
        productsRepository.delete(id);
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return productsRepository.getProductByName(name);
    }

    @Override
    public Product updateDescriptionProduct(ProductDto product) {
        productsRepository.updateDescriptionProductById(Optional.of(product.getDescription()),product.getId());
       return productsRepository.findById(product.getId());
    }

}
