package com.ies.spring_boot_ecommerce.mapper;

import com.ies.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.ies.spring_boot_ecommerce.entity.ProductCategoryEntity;
import com.ies.spring_boot_ecommerce.generics.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends GenericMapper<ProductCategoryEntity, ProductCategoryDto> {
    @Mapping(source = "categoryName", target = "name")
    ProductCategoryDto toDto(ProductCategoryEntity entity);

    @InheritInverseConfiguration
    ProductCategoryEntity toEntity(ProductCategoryDto dto);
}
