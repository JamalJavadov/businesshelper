package com.example.businesshelper.model.mapper;

import com.example.businesshelper.model.dto.ProductRequestDto;
import com.example.businesshelper.model.dto.ProductResponseDto;
import com.example.businesshelper.model.dto.ProductUpdateDto;
import com.example.businesshelper.model.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product toEntity(ProductRequestDto productRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "customerInstagramName",source = "customer.instagramName")
    ProductResponseDto toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product toEntity(ProductUpdateDto productUpdateDto,@MappingTarget Product product);

}
