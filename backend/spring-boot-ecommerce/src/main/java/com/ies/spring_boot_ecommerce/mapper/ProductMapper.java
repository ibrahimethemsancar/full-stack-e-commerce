package com.ies.spring_boot_ecommerce.mapper;

import com.ies.spring_boot_ecommerce.dto.ProductDto;
import com.ies.spring_boot_ecommerce.entity.ProductEntity;
import com.ies.spring_boot_ecommerce.generics.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<ProductEntity, ProductDto> {

    @Mapping(source = "unitsInStock", target = "stock")
    ProductDto toDto(ProductEntity entity);

    @InheritInverseConfiguration
    ProductEntity toEntity(ProductDto dto);
}
