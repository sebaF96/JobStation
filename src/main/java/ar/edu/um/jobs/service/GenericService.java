package ar.edu.um.jobs.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    T create(T entity);

    void remove(Long value);

    void update(T value);

    Optional<T> get(Long value);

    List<T> getAll();

    boolean validate(Long value);

}
