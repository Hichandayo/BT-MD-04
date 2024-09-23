package ra.mainmd04.dao;

import java.util.List;

public interface IGenericDao<T,E> {
    List<T> getAll();
    T findId(E id);
    void save(T t);
    void delete(E id);
    void update(T t);
}