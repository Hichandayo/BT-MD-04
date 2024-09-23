package ra.mainmd04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.mainmd04.dao.user.IUserDao;
import ra.mainmd04.dao.user.UserDaoImpl;
import ra.mainmd04.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private IUserDao userDao = new UserDaoImpl();

    @GetMapping("/login")
    public String showRegisterForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showLoginForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam(required = false, defaultValue = "false") boolean status) {

        User user = new User(fullName, email, password, address, phone, status);
        userDao.register(user);
        return "redirect:/users/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userDao.login(email, password);
        if (user!=null) {
            return "redirect:/users/view-cart";
        } else {
            return "login";
        }
    }

    @GetMapping("/view-cart")
    public String viewCart() {
        return "view-cart";
    }
}

