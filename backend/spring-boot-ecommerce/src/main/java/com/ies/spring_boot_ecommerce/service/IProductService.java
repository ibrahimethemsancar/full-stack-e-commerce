package com.ies.spring_boot_ecommerce.service;

import com.ies.spring_boot_ecommerce.dto.ProductDto;
import com.ies.spring_boot_ecommerce.dto.ProductListResponse;
import com.ies.spring_boot_ecommerce.entity.ProductEntity;
import com.ies.spring_boot_ecommerce.generics.GenericService;

import java.util.List;

public interface IProductService extends GenericService<ProductEntity, ProductDto> {
    /*List<ProductDto> getAllDto();*/

    ProductListResponse getAllDtoByCategoryId(Long categoryId, Integer page, Integer pageSize);

    List<ProductDto> getAllBySearch(String keyword, Integer page, Integer pageSize);
}
