package ra.mainmd04.dao.customer;

import ra.mainmd04.model.Customer;
import ra.mainmd04.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        // mo ket noi
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("select * from customer ");
            ResultSet rs = callst.executeQuery();
            while (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Customer findById(Integer id) {
        // mo ket noi
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("select * from customer where id = ?");
            callst.setInt(1,id);
            ResultSet rs = callst.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void create(Customer customer) {
        // mo ket noi
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("INSERT INTO customer(name, address, email) values (?,?,?)");
            callst.setString(1, customer.getName());
            callst.setString(2, customer.getAddress());
            callst.setString(3, customer.getEmail());
            callst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void update(Customer customer) {
        // mo ket noi
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("update customer set name = ? , address=?, email=? where id=?");
            callst.setString(1, customer.getName());
            callst.setString(2, customer.getAddress());
            callst.setString(3, customer.getEmail());
            callst.setInt(4, customer.getId());
            callst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {
        // mo ket noi
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("DELETE from customer where id = ?  ");
            callst.setInt(1, id);
            callst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }

    }
}
