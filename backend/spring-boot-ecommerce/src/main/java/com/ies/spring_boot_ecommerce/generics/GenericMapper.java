package com.ies.spring_boot_ecommerce.generics;

import java.util.List;
import java.util.Optional;

public interface GenericMapper<E extends AbstractEntity, D extends AbstractDTO> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);


    default Optional<D> toOptionalDto(Optional<E> optionalEntity) {
        if (optionalEntity.isPresent()) {
            return Optional.ofNullable(this.toDto(optionalEntity.get()));
        }
        return Optional.empty();
    }

    default Optional<E> toOptionalEntity(Optional<D> optionalDto) {
        if (optionalDto.isPresent()) {
            return Optional.ofNullable(this.toEntity(optionalDto.get()));
        }
        return Optional.empty();
    }
}

