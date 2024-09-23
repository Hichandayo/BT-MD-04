package ra.mainmd04.dao.category;

import ra.mainmd04.model.Category;
import ra.mainmd04.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("select * from category");
            ResultSet rs = sta.executeQuery();
            while (rs.next()){
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return categories;
    }


    @Override
    public Category findId(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try {
            sta = connection.prepareCall("SELECT * FROM category WHERE id = ?");
            sta.setInt(1, id);
            rs = sta.executeQuery();
            if (rs.next()) {
                return new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return null;
    }


    @Override
    public void save(Category category) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta =null;
        try{
            sta = connection.prepareCall("insert into Category (name, status) values (?, ?)");
            sta.setString(1, category.getName());
            sta.setBoolean(2, category.isStatus());
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
            sta = connection.prepareCall("delete from Category where id =?");
            sta.setInt(1, id);
            sta.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Category category) {
        Connection connection = ConnectionDB.getConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("update Category set name =?, status =? where id =?");
            sta.setString(1, category.getName());
            sta.setBoolean(2, category.isStatus());
            sta.setInt(3, category.getId());
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}