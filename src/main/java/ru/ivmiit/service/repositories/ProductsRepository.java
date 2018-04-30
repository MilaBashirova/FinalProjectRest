package ru.ivmiit.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.service.models.Category;
import ru.ivmiit.service.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByName(String name);

    Optional<Category> findByCategory(Long id);

    List<Product> findAllByCategory(Category category);

}
