package com.ies.spring_boot_ecommerce.generics;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
@NoRepositoryBean
public class AbstractRepository<E extends AbstractEntity> extends SimpleJpaRepository<E,Long> implements  GenericRepository<E>{
    private final EntityManager entityManager;
    public AbstractRepository(JpaEntityInformation<E, Long> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

}
