package ra.mainmd04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.mainmd04.dao.category.CategoryDaoImpl;
import ra.mainmd04.dao.category.ICategoryDao;
import ra.mainmd04.dao.product.IProductDao;
import ra.mainmd04.dao.product.ProductDaoImpl;
import ra.mainmd04.model.Category;
import ra.mainmd04.model.Product;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private IProductDao productDao = new ProductDaoImpl();
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @GetMapping("/list-product")
    public String listProducts(Model model) {
        List<Product> products = productDao.getAll();
        model.addAttribute("products", products);
        return "list-product";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryDao.getAll();
        model.addAttribute("categories", categories);
        return "add-product";
    }

    // Thêm danh mục mới
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productDao.save(product);
        return "redirect:/products/list-product";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Product products = productDao.findId(id);
        model.addAttribute("product", products);
        return "delete-product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDao.delete(id);
        return "redirect:/products/list-product";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productDao.findId(id);
        List<Category> categories = categoryDao.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "edit-product";
    }


    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product product) {
        productDao.update(product);
        return "redirect:/products/list-product";
    }

    @GetMapping("/add-to-cart/{id}")
    public String showAddToCartForm(@PathVariable int id, Model model) {
        Product product = productDao.findId(id);
        model.addAttribute("product", product);
        return "add-to-cart";
    }
}