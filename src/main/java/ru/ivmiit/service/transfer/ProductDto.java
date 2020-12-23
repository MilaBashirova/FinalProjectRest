package ru.ivmiit.service.transfer;


import lombok.Data;

/**
 * @author Bashirova Milyausha
 */
@Data
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private String description;
}
