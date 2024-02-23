package com.example.demo.repositories;

import java.util.List;

public interface ICRUDRepository<T, ID> {
    T save(T entity);
    void deleteById(ID id);
    List<T> findAll();
    T findById(ID id);
}