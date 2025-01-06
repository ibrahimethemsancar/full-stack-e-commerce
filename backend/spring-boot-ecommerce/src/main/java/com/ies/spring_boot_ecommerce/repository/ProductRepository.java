package com.ies.spring_boot_ecommerce.repository;

import com.ies.spring_boot_ecommerce.entity.ProductEntity;
import com.ies.spring_boot_ecommerce.generics.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends GenericRepository<ProductEntity> {
    Page<ProductEntity> findAllByCategoryId(Long categoryId, Pageable pageable);
    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<ProductEntity> searchByName(@Param("keyword") String keyword, Pageable pageable);


}
