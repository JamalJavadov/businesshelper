package com.example.businesshelper.service;

import com.example.businesshelper.model.dto.CustomerRequestDto;
import com.example.businesshelper.model.dto.CustomerResponseDto;
import com.example.businesshelper.model.dto.CustomerUpdateDto;
import com.example.businesshelper.model.dto.ProductResponseDto;
import com.example.businesshelper.model.entity.Customer;
import com.example.businesshelper.model.mapper.CustomerMapper;
import com.example.businesshelper.model.mapper.ProductMapper;
import com.example.businesshelper.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    public CustomerResponseDto create(CustomerRequestDto customerRequestDto){
        Customer customer = customerMapper.toEntity(customerRequestDto);
        return customerMapper.toDto(customerRepository.save(customer));
    }

    public CustomerResponseDto update(CustomerUpdateDto customerUpdateDto){
        Customer customer = customerRepository.findCustomerByInstagramName(customerUpdateDto.getInstagramName()).orElseThrow();
        Customer updatedCustomer = customerMapper.toEntity(customerUpdateDto,customer);
        return customerMapper.toDto(customerRepository.save(updatedCustomer));
    }

    public CustomerResponseDto get(String instagramName){
        return customerMapper.toDto(customerRepository.findCustomerByInstagramName(instagramName).orElseThrow());
    }

    public List<CustomerResponseDto> getAll(){
        return customerRepository.findAll().stream()
                .map(customer -> {
                    List<ProductResponseDto> responseDtos = customer.getProducts().stream()
                            .map(productMapper::toDto)
                            .toList();
                    CustomerResponseDto customerResponseDto = customerMapper.toDto(customer);
                    customerResponseDto.setProducts(responseDtos);
                    return customerResponseDto;
                }).toList();
    }





}
