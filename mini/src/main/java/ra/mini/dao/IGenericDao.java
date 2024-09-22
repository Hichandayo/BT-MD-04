package ra.mini.dao;

import java.util.List;

public interface IGenericDao <T,E>{
public List<T> findAll();
T findById(E id);
void create(T t);
void update(T t);
void delete(E id);
}
