package ra.mainmd04.service;

import ra.mainmd04.model.Account;

public interface IAccountService {
    Account login(String username, String password);
    void sendMoney(int idReceiver, int amount);
    Account getUserLogin();
}
