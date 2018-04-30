package ru.ivmiit.service.forms;

import lombok.Data;
import ru.ivmiit.service.models.Category;

@Data
public class ProductForm {
    private String name;
    private Integer price;
    private long category_id;
}
