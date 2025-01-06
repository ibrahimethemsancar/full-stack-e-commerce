package com.ies.spring_boot_ecommerce.service.impl;

import com.ies.spring_boot_ecommerce.dto.ProductDto;
import com.ies.spring_boot_ecommerce.entity.ProductEntity;
import com.ies.spring_boot_ecommerce.generics.AbstractService;
import com.ies.spring_boot_ecommerce.generics.GenericMapper;
import com.ies.spring_boot_ecommerce.generics.GenericRepository;
import com.ies.spring_boot_ecommerce.mapper.ProductMapper;
import com.ies.spring_boot_ecommerce.repository.ProductRepository;
import com.ies.spring_boot_ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl extends AbstractService<ProductEntity, ProductDto> implements IProductService {

    private ProductMapper productMapper;

    private ProductRepository productRepository;

    public ProductServiceImpl(GenericRepository<ProductEntity> repository,
                              GenericMapper<ProductEntity, ProductDto> productMapper,
                              ProductRepository productRepository,
                              ProductMapper mapper) {
        super(repository, productMapper);
        this.productRepository = productRepository;
        this.productMapper = mapper;
    }

   /* @Override
    public List<ProductDto> getAllDto() {
        List<ProductEntity> productList = this.productRepository.findAll();
        return productMapper.toDto(productList);
    }*/

    @Override
    public List<ProductDto> getAllDtoByCategoryId(Long categoryId, Integer pageNumber) {
        Pageable pageWithElements = checkAndObtainPageNumber(pageNumber);
        List<ProductEntity> productList = this.productRepository.findAllByCategoryId(categoryId, pageWithElements).toList();
        return productMapper.toDto(productList);
    }


    @Override
    public List<ProductDto> getAllBySearch(String keyword, Integer pageNumber) {
        Pageable pageWithElements = checkAndObtainPageNumber(pageNumber);

        List<ProductEntity> searchedProductList = this.productRepository.searchByName(keyword, pageWithElements).toList();
        return this.productMapper.toDto(searchedProductList);

    }

    private  Pageable checkAndObtainPageNumber(Integer pageNumber) {
        if(pageNumber == null){
            pageNumber = 0;
        }

        Pageable pageWithElements = PageRequest.of(pageNumber, 10);
        return pageWithElements;
    }
}
