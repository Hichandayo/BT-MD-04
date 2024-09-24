package ra.mainmd04.controller;


@Controller
@RequestMapping("/user-cart")
public class UserCartController {
    @GetMapping
    public String show(){
        return "user-cart";
    }
}
