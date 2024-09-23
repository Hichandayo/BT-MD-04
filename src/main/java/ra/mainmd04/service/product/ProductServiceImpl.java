package ra.mainmd04.service.product;

import ra.mainmd04.dao.product.IProductDao;
import ra.mainmd04.dao.product.ProductDaoImpl;
import ra.mainmd04.model.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    private IProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product findId(Integer id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Product product) {

    }
}