package ra.mainmd04.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // mo ket noi
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Aa0349811893");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("driver not found");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("Loi Mo Ket Noi");
            throw new RuntimeException(e);
        }
    }
// dong ket noi
    public static void closeConnection(Connection conn) {
        try{
            if (!conn.isClosed()){
                conn.close();
            }
        }catch(SQLException e){
            System.err.println("Loi Dong Ket noi");
            throw new RuntimeException(e);
        }
    }
}
