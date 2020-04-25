package ar.edu.um.jobs.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericServImpl<T extends Identificable> implements GenericService<T> {
    @Override
    public boolean validate(Long value) {
        return getRepository().findById(value).isPresent();

    }

    @Override
    public T create(T entity) {
        if (entity.getId() == null && !validate(entity.getId())) {
            return getRepository().save(entity);
        }
        return null;
    }

    @Override
    public void remove(Long value) {
        if (validate(value)) {
            getRepository().deleteById(value);
        }
    }

    @Override
    public T update(T entity) {
        if (validate(entity.getId())) {
            return getRepository().save(entity);
        }
        return null;
    }

    @Override
    public Optional<T> get(Long value) {
        return getRepository().findById(value);
    }

    @Override
    public List<T> getAll() {

        return getRepository().findAll();
    }

    abstract JpaRepository<T, Long> getRepository();
}
