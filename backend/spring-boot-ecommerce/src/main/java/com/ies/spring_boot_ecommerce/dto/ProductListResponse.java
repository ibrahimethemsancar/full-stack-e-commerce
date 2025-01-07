package com.ies.spring_boot_ecommerce.dto;

import com.ies.spring_boot_ecommerce.generics.AbstractDTO;
import lombok.Data;

import java.util.List;
@Data
public class ProductListResponse extends AbstractDTO {
    private List<ProductDto> products;
    private PageDto page;
}
