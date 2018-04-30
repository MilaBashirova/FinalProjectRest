package ru.ivmiit.service.services;

import ru.ivmiit.service.forms.CategoryForm;
import ru.ivmiit.service.models.Category;

import java.util.List;

public interface CategoryService {
    void addCategories(CategoryForm categoryForm);

    List<Category> findAllCategories();

    void deleteCategories(Long id);
}
