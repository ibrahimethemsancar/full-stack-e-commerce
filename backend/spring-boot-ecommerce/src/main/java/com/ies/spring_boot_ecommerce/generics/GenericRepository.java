package com.ies.spring_boot_ecommerce.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
@NoRepositoryBean
public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
