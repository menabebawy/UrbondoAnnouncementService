package com.urbondo.core;

import java.util.Optional;

public interface UrbondoRepository<T> {
    Optional<T> findById(String id);

    T save(T dao);

    void delete(T dao);
}

