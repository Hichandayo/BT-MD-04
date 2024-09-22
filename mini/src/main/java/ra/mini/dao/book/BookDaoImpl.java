package ra.mini.dao.book;

import ra.mini.dao.category.CategoryDaoImpl;
import ra.mini.dao.category.ICategoryDao;
import ra.mini.model.Book;
import ra.mini.model.Category;
import ra.mini.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    //hien thi
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        CallableStatement callSt = null;
        // mo ket noi
        Connection conn = ConnectionDB.getConnection();
        try {
            callSt = conn.prepareCall("{call ShowAllBook()}");
            ResultSet rs = callSt.executeQuery();
                    Category category = categoryDao.findById(rs.getInt("categoryId"));
            while (rs.next()) {
                if (categoryDao != null) {
                    Book book = new Book(
                            rs.getInt("id"),
                            category.getId(),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getInt("stock"),
                            rs.getInt("totalPages"),
                            rs.getInt("yearCreated"),
                            rs.getString("author"),
                            rs.getBoolean("status")
                    );
                    books.add(book);
                } else {
                    throw new NullPointerException("chua co categoryDao");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                ConnectionDB.closeConnection(conn);
            }
        }
        return books;
    }

    // lay Id
    @Override
    public Book findById(Integer id) {
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call BookFindById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                Category category = categoryDao.findById(rs.getInt("categoryId"));
                return new Book(
                        rs.getInt("id"),
                        category.getId(),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // dóng kết nối
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    // tao moi
    @Override
    public void create(Book book) {
        // mở két nối
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call AddNewBook(?, ?, ?, ?, ?, ?, ?, ?)}");
            callSt.setInt(1, book.getCategoryId());
            callSt.setString(2, book.getName());
            callSt.setDouble(3, book.getPrice());
            callSt.setInt(4, book.getStock());
            callSt.setInt(5, book.getTotalPages());
            callSt.setInt(6, book.getYearCreated());
            callSt.setString(7, book.getAuthor());
            callSt.setBoolean(8, book.isStatus());
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }// dóng kết nối
        finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    // sua
    @Override
    public void update(Book book) {
        // mở két nối
        Connection conn = ConnectionDB.getConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call UpdateBook(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, book.getCategoryId());
            callSt.setString(2, book.getName());
            callSt.setDouble(3, book.getPrice());
            callSt.setInt(4, book.getStock());
            callSt.setInt(5, book.getTotalPages());
            callSt.setInt(6, book.getYearCreated());
            callSt.setString(7, book.getAuthor());
            callSt.setBoolean(8, book.isStatus());
            callSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            callSt = conn.prepareCall("{call DeleteBookById(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
