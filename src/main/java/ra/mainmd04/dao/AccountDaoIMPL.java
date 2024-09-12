package ra.mainmd04.dao;

import ra.mainmd04.model.Account;
import ra.mainmd04.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoIMPL implements IAccountDao {
    @Override
    public Account login(String username, String password) {
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callStmt = null;
        try {
            callStmt = conn.prepareCall("{call login(?,?)}");
            callStmt.setString(1, username);
            callStmt.setString(2, password);
            ResultSet rs = callStmt.executeQuery();
            if (rs.next()) {
                Account account = new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        "",
                        rs.getString("fullname"),
                        rs.getInt("balance"));
                return account;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    @Override
    public void sendMoney(int idSender, int idReceiver, int amount) {
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callStmt1 = null;
        CallableStatement callStmt2 = null;
        try {
            conn.setAutoCommit(false);
            //tru tien
            callStmt1 = conn.prepareCall("{call changeBalance(?,?)}");
            callStmt1.setInt(1, -amount);
            callStmt1.setInt(2, idSender);
            callStmt1.executeUpdate();
            //cong tien
            callStmt2 = conn.prepareCall("{call changeBalance(?,?)}");
            callStmt2.setInt(1, amount);
            callStmt2.setInt(2, idReceiver);
            callStmt2.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}
