package ra.mainmd04.service;

import java.util.List;

public interface IGeneric <T, E>{
    List<T> getAll();
    T findId(E id);
    void save(T t);
    void delete(E id);
    void update(T t);
}