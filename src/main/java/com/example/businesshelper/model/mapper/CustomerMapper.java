package com.example.businesshelper.model.mapper;

import com.example.businesshelper.model.dto.CustomerRequestDto;
import com.example.businesshelper.model.dto.CustomerResponseDto;
import com.example.businesshelper.model.dto.CustomerUpdateDto;
import com.example.businesshelper.model.entity.Customer;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer toEntity(CustomerRequestDto customerRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerResponseDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer toEntity(CustomerUpdateDto customerUpdateDto, @MappingTarget Customer customer);
}
