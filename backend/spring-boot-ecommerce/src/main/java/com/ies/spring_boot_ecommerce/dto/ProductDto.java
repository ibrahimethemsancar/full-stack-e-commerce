package com.ies.spring_boot_ecommerce.dto;

import com.ies.spring_boot_ecommerce.entity.ProductCategoryEntity;
import com.ies.spring_boot_ecommerce.generics.AbstractDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductDto extends AbstractDTO implements Serializable {

    private Long id;

    private String sku;

    private String name;

    private String description;

    private BigDecimal unitPrice;

    private String imageUrl;

    private int stock;
}
