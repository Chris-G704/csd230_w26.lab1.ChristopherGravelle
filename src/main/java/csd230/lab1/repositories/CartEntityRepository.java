package csd230.lab1.repositories;

import java.util.List;
import java.util.Optional;


public interface CartEntityRepository<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    T save(T entity);



    void deleteById(Long id);
}