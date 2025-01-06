package com.ies.spring_boot_ecommerce.controller;

import com.ies.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.ies.spring_boot_ecommerce.entity.ProductCategoryEntity;
import com.ies.spring_boot_ecommerce.generics.AbstractController;
import com.ies.spring_boot_ecommerce.generics.GenericService;
import com.ies.spring_boot_ecommerce.service.IProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController extends AbstractController<ProductCategoryEntity, ProductCategoryDto> {
    private IProductCategoryService categoryService;
    public ProductCategoryController(GenericService<ProductCategoryEntity, ProductCategoryDto> service,
                                     IProductCategoryService categoryService) {
        super(service);
        this.categoryService = categoryService;
    }

    /*@GetMapping("/getAll")
    public ResponseEntity<List<ProductCategoryDto>> getAllDto(){
        try {
            return new ResponseEntity<>(this.categoryService.getAllDto(), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/
}
