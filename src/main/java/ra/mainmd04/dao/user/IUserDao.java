package ra.mainmd04.dao.user;


import ra.mainmd04.model.User;

public interface IUserDao {
    void register(User user);
    User login(String email, String password);
}