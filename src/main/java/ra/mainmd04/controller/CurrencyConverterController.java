package ra.mainmd04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    @RequestMapping
    public String showForm() {
        return "currency";
    }


    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String convertCurrency(
            @RequestParam("rate") double rate,
            @RequestParam("usd") double usd,
            Model model) {

        double result = rate * usd;
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);

        return "result";
    }
}