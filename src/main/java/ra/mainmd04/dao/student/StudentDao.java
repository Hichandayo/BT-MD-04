package ra.mainmd04.dao.student;


import ra.mainmd04.ConnectionDB;
import ra.mainmd04.model.Student;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

public class StudentDao implements IStudentDao{
    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("select * from student");
            ResultSet rs = sta.executeQuery();
            while(rs.next()){
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")
                );
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return students;
    }

    @Override
    public Student getById(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("select * from student where id = ?");
            sta.setInt(1, id);
            ResultSet rs = sta.executeQuery();
            if(rs.next()){
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")
                );
                return student;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void save(Student student) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("insert into student (fullName, email, address, phone, status) values (?, ?, ?, ?, ?)");
            sta.setString(1, student.getFullName());
            sta.setString(2, student.getEmail());
            sta.setString(3, student.getAddress());
            sta.setString(4, student.getPhone());
            sta.setBoolean(5, student.isStatus());
            sta.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Student student) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("update student set fullName=?, email=?, address=?, phone=?, status=? where id=?");
            sta.setString(1, student.getFullName());
            sta.setString(2, student.getEmail());
            sta.setString(3, student.getAddress());
            sta.setString(4, student.getPhone());
            sta.setBoolean(5, student.isStatus());
            sta.setInt(6, student.getId());
            sta.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("delete from student where id=?");
            sta.setInt(1, id);
            sta.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try {
            // Sử dụng cú pháp LIKE để tìm kiếm tương đối
            sta = connection.prepareCall("select * from student where fullName like ?");
            sta.setString(1, "%" + name + "%");
            ResultSet rs = sta.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return students;
    }

}