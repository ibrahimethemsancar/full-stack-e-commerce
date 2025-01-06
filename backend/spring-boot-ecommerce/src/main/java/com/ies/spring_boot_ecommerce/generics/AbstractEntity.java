package com.ies.spring_boot_ecommerce.generics;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private boolean active;

    @CreatedDate
    private LocalDateTime dateCreated = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime lastUpdated = LocalDateTime.now();
}
