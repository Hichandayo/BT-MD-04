package ra.mainmd04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ra.mainmd04.model.Mail;

@Controller
public class ConfigureController {

    @GetMapping ("/updateConfig")
    public String updateConfig(Model model){
        Mail mail = new Mail(1, "vi", 10, true, "This is my signature");
        model.addAttribute("mail", mail);
        return "updateConfig";
    }

    @PostMapping("/doAdd")
    public String handleAdd(Mail mail, Model model){
        model.addAttribute("mail", mail);
        return "showConfig";
    }
}
