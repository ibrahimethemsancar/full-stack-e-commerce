package com.ies.spring_boot_ecommerce.generics;

import java.util.List;
import java.util.Optional;

public interface GenericService <E extends AbstractEntity, D extends AbstractDTO>{
    Optional<D> findById(Long id);
    List<D> getAll();
}
