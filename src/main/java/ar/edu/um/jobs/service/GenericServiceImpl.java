package ar.edu.um.jobs.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T extends Identificable> implements GenericService<T> {
    @Override
    public boolean validate(Long value) {
        return getRepository().findById(value).isPresent();

    }

    @Override
    public T create(T entity) {
        if (entity.getId() == null) {
        return getRepository().save(entity);
        }else{
            return null;
        }

    }

    @Override
    public void remove(Long value) {
        if (validate(value)) {
            getRepository().deleteById(value);
        }
    }

    @Override
    public void update(T entity) {
        if (entity.getId()!=null && validate(entity.getId())) {
            getRepository().save(entity);
        }
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
