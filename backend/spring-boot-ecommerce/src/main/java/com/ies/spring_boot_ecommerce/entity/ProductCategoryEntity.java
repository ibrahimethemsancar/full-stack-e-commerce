package com.ies.spring_boot_ecommerce.entity;

import com.ies.spring_boot_ecommerce.generics.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "product_category")
public class ProductCategoryEntity extends AbstractEntity {

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<ProductEntity> products;
}
