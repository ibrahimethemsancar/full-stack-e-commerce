package com.ies.spring_boot_ecommerce.generics;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AbstractDTO implements Serializable {
    private Boolean isDeleted = Boolean.FALSE;
    private LocalDateTime createdDate = LocalDateTime.now();
}
