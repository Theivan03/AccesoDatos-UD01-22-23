package model.repository;

import java.util.List;
import java.util.UUID;

public interface ICrudRepository<T, E> {
    void save (T entity);
    T findById(E id);
    List<T> findAll();
    boolean delete (E id);
    boolean update(T entity);


}
