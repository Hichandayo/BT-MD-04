package ra.mini.service.category;

import ra.mini.dao.category.CategoryDaoImpl;
import ra.mini.dao.category.ICategoryDao;
import ra.mini.model.Category;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public void create(Category category) {
    categoryDao.create(category);
    }

    @Override
    public void update(Category category) {
    categoryDao.update(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }
}
