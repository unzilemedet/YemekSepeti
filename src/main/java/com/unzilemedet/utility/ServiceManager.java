package com.unzilemedet.utility;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T, ID> implements ICrudService<T, ID> {

    private final JpaRepository<T, ID> repository;

    public ServiceManager(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        return null;
    }

    @Override
    public T update(T t) {
        return repository.save(t);
    }

    @Override
    public T delete(ID id) {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}