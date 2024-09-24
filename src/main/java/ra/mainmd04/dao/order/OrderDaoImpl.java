package ra.mainmd04.dao.order;


import org.springframework.stereotype.Repository;
import ra.mainmd04.model.Order;
import ra.mainmd04.util.ConnectionDB;

import java.sql.*;

@Repository
public class OrderDaoImpl implements IOrderDao {
    @Override
    public void save(Order order) {
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement sta = null;
        try {
            sta = connection.prepareStatement("INSERT INTO `order` (userId, totals, status) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            sta.setInt(1, order.getUserId());
            sta.setDouble(2, order.getTotals());
            sta.setString(3, order.getStatus().name());
            sta.executeUpdate();

            // Lấy ID của đơn hàng vừa tạo
            ResultSet generatedKeys = sta.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

}
