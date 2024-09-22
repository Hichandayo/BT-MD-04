package ra.mini.controller;

import ra.mini.model.Category;
import ra.mini.service.category.CategoryServiceImpl;
import ra.mini.service.category.ICategoryService;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebService(values = "/category")
public class CategoryController extends HttpServlet {
    private ICategoryService categoryService = new CategoryServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "SHOW":
                    Integer idShow = Integer.valueOf(req.getParameter("id"));
                    req.setAttribute("category", categoryService.findById(idShow));
                    req.getRequestDispatcher("/views/category.jsp").forward(req, res);
                    break;
                case "UPDATE":
                    Integer idEdit = Integer.valueOf(req.getParameter("id"));
                    req.setAttribute("category", categoryService.findById(idEdit));
                    req.getRequestDispatcher("/views/category.jsp").forward(req, res);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(req.getParameter("id"));
                    Category category = categoryService.findById(idDel);
                    req.setAttribute("category", category);
                    req.getRequestDispatcher("/views/category.jsp").forward(req, res);
                    break;
                case "CREATED":
                    req.getRequestDispatcher("/views/category.jsp").forward(req, res);
                    break;
                default:
                    res.sendRedirect(req.getContextPath() + "/categories");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
