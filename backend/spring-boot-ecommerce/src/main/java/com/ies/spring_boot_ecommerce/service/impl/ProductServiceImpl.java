package com.ies.spring_boot_ecommerce.service.impl;

import com.ies.spring_boot_ecommerce.dto.PageDto;
import com.ies.spring_boot_ecommerce.dto.ProductDto;
import com.ies.spring_boot_ecommerce.dto.ProductListResponse;
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
    

    @Override
    public ProductListResponse getAllDtoByCategoryId(Long categoryId, Integer pageNumber, Integer pageSize) {
        Pageable pageWithElements = this.checkAndObtainPageNumber(pageNumber, pageSize);

        Page<ProductEntity> productListWithPage = this.productRepository.findAllByCategoryId(categoryId, pageWithElements);
        List<ProductEntity> productList  = productListWithPage.getContent();

        ProductListResponse productListResponse = new ProductListResponse();

        List<ProductDto> productDtoList = productMapper.toDto(productList);
        productListResponse.setProducts(productDtoList);

        PageDto pageDto = new PageDto();
        pageDto.setTotalPages((long) productListWithPage.getTotalPages());
        pageDto.setTotalElements(productListWithPage.getTotalElements());
        pageDto.setNumber((long) productListWithPage.getNumber());
        pageDto.setSize((long) productListWithPage.getSize());

        productListResponse.setPage(pageDto);
        return productListResponse;
    }

    @Override
    public ProductListResponse getAllBySearch(String keyword, Integer pageNumber, Integer pageSize) {
        Pageable pageWithElements = checkAndObtainPageNumber(pageNumber, pageSize);

        Page<ProductEntity> searchedProductListWithPage = this.productRepository.searchByName(keyword, pageWithElements);
        List<ProductEntity> productList = searchedProductListWithPage.getContent();

        ProductListResponse productListResponse = new ProductListResponse();
        List<ProductDto> productDtoList = this.productMapper.toDto(productList);
        productListResponse.setProducts(productDtoList);

        PageDto pageDto = new PageDto();
        pageDto.setTotalPages((long) searchedProductListWithPage.getTotalPages());
        pageDto.setTotalElements(searchedProductListWithPage.getTotalElements());
        pageDto.setNumber((long) searchedProductListWithPage.getNumber());
        pageDto.setSize((long) searchedProductListWithPage.getSize());

        productListResponse.setPage(pageDto);

        return productListResponse;

    }

    private  Pageable checkAndObtainPageNumber(Integer pageNumber, Integer pageSize) {
        if(pageNumber == null){
            pageNumber = 0;
        }
        if(pageSize == null){
            pageSize = 10;
        }

        return PageRequest.of(pageNumber, pageSize);
    }
}
