package com.ies.spring_boot_ecommerce.service.impl;

import com.ies.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.ies.spring_boot_ecommerce.entity.ProductCategoryEntity;
import com.ies.spring_boot_ecommerce.generics.AbstractService;
import com.ies.spring_boot_ecommerce.generics.GenericMapper;
import com.ies.spring_boot_ecommerce.generics.GenericRepository;
import com.ies.spring_boot_ecommerce.mapper.ProductCategoryMapper;
import com.ies.spring_boot_ecommerce.repository.ProductCategoryRepository;
import com.ies.spring_boot_ecommerce.service.IProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl extends AbstractService<ProductCategoryEntity, ProductCategoryDto> implements IProductCategoryService {

    private ProductCategoryRepository categoryRepository;
    private ProductCategoryMapper  categoryMapper;

    public ProductCategoryServiceImpl(GenericRepository<ProductCategoryEntity> repository,
                                      GenericMapper<ProductCategoryEntity, ProductCategoryDto> productCategoryMapper,
                                      ProductCategoryRepository categoryRepository,
                                      ProductCategoryMapper categoryMapper) {
        super(repository, productCategoryMapper);
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<ProductCategoryDto> getAllDto() {
        List<ProductCategoryEntity> entityList = this.categoryRepository.findAll();
        return this.categoryMapper.toDto(entityList);
    }
}
