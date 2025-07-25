package com.example.businesshelper.model.dto;


import com.example.businesshelper.model.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private String description;

    private String productUrl;

    private double purchasePrice;

    private double sellingPrice;

    private Category category;

    private String customerInstagramName;
}
