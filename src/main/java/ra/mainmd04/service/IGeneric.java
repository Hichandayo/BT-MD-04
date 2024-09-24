package ra.mainmd04.service;

import java.util.List;

public interface IGeneric <T, E>{
    List<T> getAll();
    T findById(E id);
    void update(T t);
    void delete(E id);
    void save(T t);
}
