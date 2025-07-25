package com.example.businesshelper.service;

import com.example.businesshelper.model.dto.CustomerResponseDto;
import com.example.businesshelper.model.dto.ProductResponseDto;
import com.example.businesshelper.model.dto.StaticsDto;
import com.example.businesshelper.model.mapper.CustomerMapper;
import com.example.businesshelper.model.mapper.ProductMapper;
import com.example.businesshelper.repository.CustomerRepository;
import com.example.businesshelper.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaticsService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CustomerMapper customerMapper;

    public StaticsDto monthlyStatics(Month month){
        StaticsDto staticsDto = new StaticsDto();
        final double[] income = {0};
        final double[] allPurchasePrice = {0};
        List<ProductResponseDto> products = productRepository.findAll().stream()
                .filter(product -> {
                    return product.getCreatedTime().getMonth().equals(month);
                })
                .map(product -> {
                    allPurchasePrice[0] +=product.getPurchasePrice();
                    income[0] +=product.getSellingPrice()-product.getPurchasePrice();

                    return productMapper.toDto(product);
                })
                .toList();

        List<CustomerResponseDto> customers = customerRepository.findAll().stream()
                .filter(customer -> {
                    return customer.getLocalDateTime().getMonth().equals(month);
                })
                .map(customerMapper::toDto)
                .toList();

        staticsDto.setProductResponseDtos(products);
        staticsDto.setNewCustomers(customers);
        staticsDto.setIncome(income[0]);
        staticsDto.setAllPurchasePrice(allPurchasePrice[0]);
        return staticsDto;
    }



}
