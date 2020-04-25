package ar.edu.um.jobs.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T,Id>{
    T create(T entity);
    void remove(Id value);
    T update(T value);
   Optional <T> get(Id value);
    List<T> getAll();


}
