package ra.mainmd04.service.category;

import ra.mainmd04.dao.category.CategoryDaoImpl;
import ra.mainmd04.dao.category.ICategoryDao;
import ra.mainmd04.model.Category;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category findId(Integer id) {
        return categoryDao.findId(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }
}