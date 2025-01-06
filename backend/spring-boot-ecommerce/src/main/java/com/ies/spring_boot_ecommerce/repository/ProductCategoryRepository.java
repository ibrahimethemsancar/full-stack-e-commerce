package com.ies.spring_boot_ecommerce.repository;

import com.ies.spring_boot_ecommerce.entity.ProductCategoryEntity;
import com.ies.spring_boot_ecommerce.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends GenericRepository<ProductCategoryEntity> {
}
