package ra.mainmd04.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // mở kết nối
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?createDatabaseIfItNotExists=true", "root", "Aa0349811893");
            return conn;
        } catch (ClassNotFoundException e){
            // lớp ko tìm thấy
            System.err.println("Driver not found");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("lỗi kết nối");
            throw new RuntimeException(e);
        }
    }
    // đóng kết nối
    public static void closeConnection(Connection conn){
        try{
            if (!conn.isClosed()){
                conn.close();
            }
        }catch (SQLException e){
            System.err.println("loi ket noi");
        }
    }
}
