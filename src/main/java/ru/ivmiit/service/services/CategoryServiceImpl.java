package ru.ivmiit.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivmiit.service.forms.CategoryForm;
import ru.ivmiit.service.models.Category;
import ru.ivmiit.service.models.Product;
import ru.ivmiit.service.repositories.CategoryRepository;
import ru.ivmiit.service.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategories(CategoryForm categoryForm) {
        Category category = Category.builder()
                .name(categoryForm.getName())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategories(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        List<Product> products = productsRepository.findAllByCategory(category.get());
        if (products.size() > 0) {
            for (Product elem : products) {
                productsRepository.delete(elem);
            }
        }
        categoryRepository.delete(id);

    }


}
