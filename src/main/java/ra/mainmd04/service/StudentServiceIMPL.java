package ra.mainmd04.service;


import ra.mainmd04.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Aa0349811893";

    private static final String INSERT_STUDENT_SQL = "INSERT INTO student (fullName, email, address, phone, status) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "SELECT id, fullName, email, address, phone, status FROM student WHERE id = ?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM student WHERE id = ?";
    private static final String UPDATE_STUDENT_SQL = "UPDATE student SET fullName = ?, email = ?, address = ?, phone = ?, status = ? WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertStudent(Student student){
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setBoolean(5, student.isStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                boolean status = rs.getBoolean("status");
                student = new Student(id, fullName, email, address, phone, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                boolean status = rs.getBoolean("status");
                students.add(new Student(id, fullName, email, address, phone, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setBoolean(5, student.isStatus());
            preparedStatement.setInt(6, student.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
}