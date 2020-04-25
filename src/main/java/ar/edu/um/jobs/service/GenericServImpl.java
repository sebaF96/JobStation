package ar.edu.um.jobs.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericServImpl<T extends Identificable,Id> implements  GenericService<T,Id>{
    @Override
    public T create(T entity) {
        entity.getId();
        return null;
    }

    @Override
    public void remove(Id value) {

    }

    @Override
    public T update(T value) {
        return null;
    }

    @Override
    public Optional<T> get(Id value) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {

        return getRepository().findAll();
    }
    public abstract JpaRepository<T,Id> getRepository();
}
