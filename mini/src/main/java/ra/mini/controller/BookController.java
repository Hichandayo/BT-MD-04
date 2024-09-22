package ra.mini.controller;

import ra.mini.model.Book;
import ra.mini.model.Category;
import ra.mini.service.book.BookServiceImpl;
import ra.mini.service.book.IBookService;
import ra.mini.service.category.CategoryServiceImpl;
import ra.mini.service.category.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/book")
public class BookController extends HttpServlet {
    private IBookService bookService = new BookServiceImpl();
    private ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        List<Category> categories = categoryService.findAll();
        if (action != null) {
            switch (action) {
                case "CREATED":
                    req.setAttribute("categories", categories);
                    req.getRequestDispatcher("/views/book.jsp").forward(req, res);
                    break;
                case "SHOW":
                    // hiển thị chi tiết book
                    Integer idDetails = Integer.valueOf(req.getParameter("id"));
                    req.setAttribute("book", bookService.findById(idDetails));
                    req.getRequestDispatcher("/views/book.jsp").forward(req, res);
                    break;
                case "UPDATE":
                    //  cập nhật book
                    Integer idEdit = Integer.valueOf(req.getParameter("id"));
                    Book book1 = bookService.findById(idEdit);
                    List<Category> categor = categoryService.findAll();
                    req.setAttribute("book", book1);
                    req.setAttribute("categories", categories);
                    req.getRequestDispatcher("/views/book.jsp").forward(req, res);
                    break;
                case "DELETE":
                    // xóa book
                    Integer idDel = Integer.valueOf(req.getParameter("id"));
                    Book book = bookService.findById(idDel);
                    req.setAttribute("books", book);
                    req.getRequestDispatcher("/views/book.jsp").forward(req, res);
                    break;
                default:
                    resp.sendRedirect(req.getContextPath() + "/categories?action=list");
            }
        } else {
            resp.sendRedirect("/views?action=");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
