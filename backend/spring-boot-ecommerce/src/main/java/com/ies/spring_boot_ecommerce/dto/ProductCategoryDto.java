package com.ies.spring_boot_ecommerce.dto;

import com.ies.spring_boot_ecommerce.generics.AbstractDTO;
import lombok.Data;

import java.io.Serializable;
@Data
public class ProductCategoryDto extends AbstractDTO implements Serializable {
    private Long id;
    private String name;
}
