package com.ies.spring_boot_ecommerce.generics;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractService<E extends AbstractEntity, D extends AbstractDTO> implements GenericService<E, D> {

    private GenericRepository<E> repository;
    private GenericMapper<E, D> mapper;

    public AbstractService(GenericRepository<E> repository, GenericMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<D> findById(Long id) {
        Optional<E> optionalEntity = this.repository.findById(id);
        return optionalEntity.map(e -> this.mapper.toDto(e));

    }

    @Override
    public List<D> getAll() {
        List<E> allEntities = this.repository.findAll();

        return allEntities.stream()
                .map(entity -> this.mapper.toDto(entity))
                .collect(Collectors.toList());
    }
}
