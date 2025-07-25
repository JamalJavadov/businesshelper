package com.example.businesshelper.model.mapper;

import com.example.businesshelper.model.dto.ProductRequestDto;
import com.example.businesshelper.model.dto.ProductResponseDto;
import com.example.businesshelper.model.dto.ProductUpdateDto;
import com.example.businesshelper.model.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product toEntity(ProductRequestDto productRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductResponseDto toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product toEntity(ProductUpdateDto productUpdateDto,@MappingTarget Product product);

}
