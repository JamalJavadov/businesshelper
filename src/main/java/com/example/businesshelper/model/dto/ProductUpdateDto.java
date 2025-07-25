package com.example.businesshelper.model.dto;


import com.example.businesshelper.model.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUpdateDto {
    private long id;

    private String description;

    private String imageUrl;

    private String productUrl;

    private double purchasePrice;

    private double sellingPrice;

    private Category category;

    private String customerInstagramName;

    private boolean isGivenToCustomer;
}
