package com.ies.spring_boot_ecommerce.controller;

import com.ies.spring_boot_ecommerce.dto.ProductDto;
import com.ies.spring_boot_ecommerce.dto.ProductListResponse;
import com.ies.spring_boot_ecommerce.entity.ProductEntity;
import com.ies.spring_boot_ecommerce.generics.AbstractController;
import com.ies.spring_boot_ecommerce.generics.GenericService;
import com.ies.spring_boot_ecommerce.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController<ProductEntity, ProductDto> {
    IProductService productService;

    public ProductController(GenericService<ProductEntity, ProductDto> service, IProductService productService) {
        super(service);
        this.productService = productService;
    }

    @GetMapping("/getAll/{categoryId}")
    public ResponseEntity<ProductListResponse> getAllByCategoryId(@PathVariable Long categoryId,
                                                                  @RequestParam(value = "page", required = false) Integer page,
                                                                  @RequestParam(value = "size", required = false) Integer pageSize) {
        try {
            return new ResponseEntity<>(this.productService.getAllDtoByCategoryId(categoryId, page, pageSize), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ProductListResponse> getAllBySearch(@RequestParam(value = "keyword", required = false) String keyword,
                                                           @RequestParam(value = "page", required = false) Integer page,
                                                           @RequestParam(value = "size", required = false) Integer pageSize) {
        try {
            return new ResponseEntity<>(this.productService.getAllBySearch(keyword, page, pageSize), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
