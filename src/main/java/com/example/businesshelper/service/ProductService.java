package com.example.businesshelper.service;

import com.example.businesshelper.model.dto.ProductRequestDto;
import com.example.businesshelper.model.dto.ProductResponseDto;
import com.example.businesshelper.model.dto.ProductUpdateDto;
import com.example.businesshelper.model.entity.Customer;
import com.example.businesshelper.model.entity.Product;
import com.example.businesshelper.model.mapper.ProductMapper;
import com.example.businesshelper.repository.CustomerRepository;
import com.example.businesshelper.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CustomerRepository customerRepository;

    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        Customer customer = customerRepository.findCustomerByInstagramName(productRequestDto.getCustomerInstagramName()).orElseThrow();
        product.setActive(true);
        product.setCustomer(customer);
        return productMapper.toDto(productRepository.save(product));
    }

    public ProductResponseDto update(ProductUpdateDto productUpdateDto) {
        Product product = productRepository.findById(productUpdateDto.getId()).orElseThrow();

        Product updatedProduct = productMapper.toEntity(productUpdateDto, product);

        return productMapper.toDto(productRepository.save(updatedProduct));
    }

    public ProductResponseDto get(long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.toDto(product);
    }

    public List<ProductResponseDto> getAll(){
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }


}
