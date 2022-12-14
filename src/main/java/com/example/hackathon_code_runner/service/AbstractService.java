package com.example.hackathon_code_runner.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID, R extends CrudRepository<T, ID>> implements Service<T,ID> {

    private final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public T getOne(ID id) {
        return (T) repository.getClass();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T editEntity(T entity) {
        return repository.save(entity);
    }
}
