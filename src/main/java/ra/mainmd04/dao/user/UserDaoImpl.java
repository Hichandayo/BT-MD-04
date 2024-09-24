package ra.mainmd04.dao.user;

import org.springframework.stereotype.Repository;
import ra.mainmd04.model.User;
import ra.mainmd04.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements IUserDao{
    @Override
    public void register(User user){
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("insert into user (fullName, email, password, address, phone, status) values (?, ?, ?, ?, ?, ?)");
            sta.setString(1, user.getFullName());
            sta.setString(2, user.getEmail());
            sta.setString(3, user.getPassword());
            sta.setString(4, user.getAddress());
            sta.setString(5, user.getPhone());
            sta.setBoolean(6, true);
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
    @Override
    public User login(String email, String password){
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try{
            sta = connection.prepareCall("select * from user where email =? and password =? and status = true");
            sta.setString(1, email);
            sta.setString(2, password);
            rs = sta.executeQuery();
            if (rs.next()){
                return new User(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")
                );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return null;
    }
}
