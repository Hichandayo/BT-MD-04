package ra.mini.service;

import java.util.List;

public interface IGenericService <T,E>{
    public List<T> findAll();
    T findById(E id);
    void create(T t);
    void update(T t);
    void delete(E id);
}
