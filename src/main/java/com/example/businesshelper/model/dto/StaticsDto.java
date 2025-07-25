package com.example.businesshelper.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaticsDto {
    List<ProductResponseDto> productResponseDtos;

    double allPurchasePrice;

    double income;

    List<CustomerResponseDto> newCustomers;


}
