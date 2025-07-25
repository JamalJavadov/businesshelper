package com.example.businesshelper.model.dto;

import com.example.businesshelper.model.entity.Product;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateDto {
    private String instagramName;

    private String phoneNumber;

    @Cascade(CascadeType.PERSIST)
    private List<Product> products;

    private String description;
}
