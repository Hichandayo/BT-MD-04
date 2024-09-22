package ra.mini.service.book;

import ra.mini.dao.book.BookDaoImpl;
import ra.mini.dao.book.IBookDao;
import ra.mini.model.Book;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public void create(Book book) {
    bookDao.create(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(Integer id) {
    bookDao.delete(id);
    }
}
