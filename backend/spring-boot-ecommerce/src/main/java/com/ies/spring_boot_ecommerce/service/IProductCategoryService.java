package com.ies.spring_boot_ecommerce.service;


import com.ies.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.ies.spring_boot_ecommerce.entity.ProductCategoryEntity;
import com.ies.spring_boot_ecommerce.generics.GenericService;

import java.util.List;

public interface IProductCategoryService extends GenericService<ProductCategoryEntity, ProductCategoryDto> {
    List<ProductCategoryDto> getAllDto();
}
