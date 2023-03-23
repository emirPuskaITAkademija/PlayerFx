package com.lines.connected.playerfx.product.dao;

import java.util.List;

public interface Dao<E>{
    /**
     * CREATE
     */
    E save(E entity);

    /**
     * RETRIEVE
     */
    List<E> getAll();

    E get(Long id);

    /**
     * UPDATE
     */
    E update(E entity);

    /**
     * DELETE
     */
    boolean delete(E entity);
}
