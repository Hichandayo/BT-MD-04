package ra.mainmd04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.mainmd04.dao.category.CategoryDaoImpl;
import ra.mainmd04.dao.category.ICategoryDao;
import ra.mainmd04.model.Category;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @GetMapping("/list-category")
    public String listCategories(Model model) {
        List<Category> categories = categoryDao.getAll();
        model.addAttribute("categories", categories);
        return "list-category";
    }


    @GetMapping("/add")
    public String showAddForm() {
        return "add-category";
    }

    // Thêm danh mục mới
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryDao.save(category);
        return "redirect:/categories/list-category";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Category category = categoryDao.findId(id);
        model.addAttribute("category", category);
        return "edit-category";
    }


    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("category") Category category) {
        categoryDao.update(category);
        return "redirect:/categories/list-category";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Category category = categoryDao.findId(id);
        model.addAttribute("category", category);
        return "delete-category";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryDao.delete(id); // Xóa danh mục
        return "redirect:/categories/list-category";
    }



    @PostMapping("/toggle-status/{id}")
    public String toggleCategoryStatus(@PathVariable int id) {
        Category category = categoryDao.findId(id);
        category.setStatus(!category.isStatus());
        categoryDao.update(category);
        return "redirect:/categories/list-category";
    }
}