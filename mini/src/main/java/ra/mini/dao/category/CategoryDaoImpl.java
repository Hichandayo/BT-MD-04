package ra.mini.dao.category;

import ra.mini.model.Category;
import ra.mini.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    // hien thi
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call ShowAllCategory()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // dóng kết nối
        finally {
            ConnectionDB.closeConnection(conn);
        }
        return categories;
    }
// lay Id
    @Override
    public Category findById(Integer id) {
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call CategoryFindById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                return category;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // dóng kết nối
        finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    // Them moi
    @Override
    public void create(Category category) {
        // mở két nối
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt =null;
        try {
            callSt = conn.prepareCall("{call AddNewCategory(?,?)}");
            callSt.setString(1, category.getName());
            callSt.setBoolean(2, category.isStatus());
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // dóng kết nối
            ConnectionDB.closeConnection(conn);
        }
    }
 // sua
    @Override
    public void update(Category category) {
        // mở két nối
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try{
            callSt = conn.prepareCall("{call UpdateCategory(?,?,?)}");
            callSt.setInt(1,category.getId());
            callSt.setString(2,category.getName());
            callSt.setBoolean(3,category.isStatus());
            callSt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            // dóng kết nối
            ConnectionDB.closeConnection(conn);
        }
    }
// xoa
    @Override
    public void delete(Integer id) {
        // mở két nối
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call DeleteCategoryById(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // dóng kết nối
            ConnectionDB.closeConnection(conn);
        }
    }
}
