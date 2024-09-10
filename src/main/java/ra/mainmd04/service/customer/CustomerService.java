package ra.mainmd04.service.customer;

import ra.mainmd04.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerService implements ICustomerService {
    private List<Customer> list = new ArrayList<>();

    public CustomerService() {
        // khơi tao giá trị ban dau
        list.add(new Customer(1, "Nguyễn Văn A", "Hưng Nguyên", "hung@gmail.com"));
        list.add(new Customer(2, "Nguyễn Văn B", "Hưng Nguyên", "hung@gmail.com"));
        list.add(new Customer(3, "Nguyễn Văn C", "Hưng Nguyên", "hung@gmail.com"));
    }

    @Override
    public List<Customer> findAll() {
        return list;
    }

    @Override
    public Customer findById(Integer id) {

        return list.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId())==null){
            customer.setId(getNewId());
            list.add(customer);
        }else{
            // chinh sua
            list.set(list.indexOf(findById(customer.getId())),customer);
        }
    }

    @Override
    public void delete(Integer id) {
        Customer del = findById(id);
        if (del !=null){
            list.remove(del); // xóa
        }

    }
    private int getNewId(){
        return list.stream().map(Customer::getId).max(Comparator.naturalOrder()).orElse(0)+1;
    }
}
