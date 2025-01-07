package com.ies.spring_boot_ecommerce.dto;

import com.ies.spring_boot_ecommerce.generics.AbstractDTO;
import lombok.Data;

@Data
public class PageDto extends AbstractDTO {
    private Long size;
    private Long totalElements;
    private Long totalPages;
    private Long number;
}
