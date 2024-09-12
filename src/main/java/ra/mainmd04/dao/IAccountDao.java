package ra.mainmd04.dao;

import ra.mainmd04.model.Account;

public interface IAccountDao {
    Account login(String username, String password);

    void sendMoney(int idSender, int idReceiver, int amount);
}
