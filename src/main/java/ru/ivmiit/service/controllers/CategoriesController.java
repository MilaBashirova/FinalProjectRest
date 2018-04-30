package ru.ivmiit.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.service.forms.CategoryForm;
import ru.ivmiit.service.forms.ProductForm;
import ru.ivmiit.service.models.Category;
import ru.ivmiit.service.services.CategoryService;

import java.util.List;

@RestController
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/addCategory")
    public String getCategory() {
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Object> addCategory(@RequestBody CategoryForm categoryForm) {
        categoryService.addCategories(categoryForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @DeleteMapping("/categories/{category-id}")
    public void deleteCategory(@PathVariable("category-id") Long Id) {
        categoryService.deleteCategories(Id);
    }

}
