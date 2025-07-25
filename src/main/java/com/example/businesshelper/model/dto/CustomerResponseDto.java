package com.example.businesshelper.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {
    private String instagramName;

    private String phoneNumber;

    private List<ProductResponseDto> products;

    private String description;
}
