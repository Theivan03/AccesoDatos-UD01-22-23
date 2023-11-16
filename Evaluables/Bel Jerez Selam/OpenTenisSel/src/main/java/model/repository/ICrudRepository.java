package model.repository;

import java.util.List;
import java.util.UUID;

public interface ICrudRepository<T, E> {
    // Apartado 1
    void save (T entity);
    T findById(E id);
    List<T> findAll();

    // Apartado 2
    boolean delete (E id);
    boolean update (T entity);

}
