package model.repository;

import java.util.List;

public interface ICrudRepository<T, E> {
    T findById(E id);
    List<T> findAll();
}
