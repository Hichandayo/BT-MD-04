package ra.mainmd04.dao;

import ra.mainmd04.model.Student;

import java.util.List;

public interface IGenericDao <T, E>{
    List<T> getAll();
    T getById(E id);
    void save(T t);
    void update(T t);
    void delete(E id);
    List<Student> searchByName(String name);
}
