package ra.mainmd04.service;

import ra.mainmd04.dao.AccountDaoIMPL;
import ra.mainmd04.dao.IAccountDao;
import ra.mainmd04.model.Account;

public class AccountServiceIMPL implements IAccountService {
    private static Account userLogin = null;
    private IAccountDao accountDao = new AccountDaoIMPL();

    @Override
    public Account login(String username, String password) {
        Account user = accountDao.login(username,password);
        if (user != null) {
            userLogin = user;
            return user;
        }else {
            throw new RuntimeException("Sai Thong tin dang nhap");
        }
    }

    public Account getUserLogin() {
        return userLogin;
    }

    @Override
    public void sendMoney(int idReceiver, int amount) {
        // gọi sang dao để thục hien chuyen tien
        try {
            accountDao.sendMoney(userLogin.getId(), idReceiver, amount);
            userLogin.setBalance(userLogin.getBalance()-amount);
        }catch (RuntimeException e){
                throw new RuntimeException(e);
        }
    }

}
