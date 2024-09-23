package ra.mainmd04.dao.product;

import ra.mainmd04.model.Product;
import ra.mainmd04.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try {
            sta = connection.prepareCall("SELECT * FROM product");
            ResultSet rs = sta.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("category_id"),
                        rs.getBoolean("status")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product findId(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("select * from product where id =?");
            sta.setInt(1, id);
            ResultSet rs = sta.executeQuery();
            if (rs.next()){
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("category_id"),
                        rs.getBoolean("status")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void save(Product product) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta =null;
        try{
            sta = connection.prepareCall("insert into product (name, price, stock, category_id, status) values (?,?,?,?,?)");
            sta.setString(1, product.getName());
            sta.setDouble(2, product.getPrice());
            sta.setInt(3, product.getStock());
            sta.setInt(4, product.getCategory_id());
            sta.setBoolean(5, product.isStatus());
            sta.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("delete from product where id =?");
            sta.setInt(1, id);
            sta.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Product product) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("update product set name =?, price =?, stock =?, category_id =?, status =? where id =?");
            sta.setString(1, product.getName());
            sta.setDouble(2, product.getPrice());
            sta.setInt(3, product.getStock());
            sta.setInt(4, product.getCategory_id());
            sta.setBoolean(5, product.isStatus());
            sta.setInt(6, product.getId());
            sta.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}