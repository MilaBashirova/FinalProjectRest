package ru.ivmiit.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.service.models.Category;
import ru.ivmiit.service.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByName(String name);

    List<Product> findAllByCategory(Category category);
    Product findById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update product  set  description= ?1" +
            "  where id =?2", nativeQuery = true)
    void updateDescriptionProductById( Optional<String> description, Long productId);
}
