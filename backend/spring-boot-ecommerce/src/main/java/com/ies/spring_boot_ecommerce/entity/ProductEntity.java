package com.ies.spring_boot_ecommerce.entity;

import com.ies.spring_boot_ecommerce.generics.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name ="product")
public class ProductEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false,referencedColumnName = "id")
    private ProductCategoryEntity category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "units_in_stock")
    private int unitsInStock;
}
