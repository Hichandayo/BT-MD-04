package ra.mainmd04.service.customer;

import ra.mainmd04.dao.customer.CustomerDao;
import ra.mainmd04.dao.customer.ICustomerDao;
import ra.mainmd04.model.Customer;


import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerDao customerDao = new CustomerDao();


    @Override
    public List<Customer> findAll() {
        return  customerDao.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId())!=null){
            customerDao.update(customer);
        }else{
            // chinh sua
            customerDao.create(customer);
        }
    }

    @Override
    public void delete(Integer id) {
       customerDao.delete(id);

    }

}
