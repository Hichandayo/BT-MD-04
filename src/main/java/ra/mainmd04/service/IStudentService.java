package ra.mainmd04.service;

import ra.mainmd04.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    void insertStudent(Student student);
    Student selectStudent(int id);
    List<Student> selectAllStudents();
    boolean deleteStudent(int id) throws SQLException;
    boolean updateStudent(Student student);
}
