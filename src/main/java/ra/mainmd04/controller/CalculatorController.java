package ra.mainmd04.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("/calculator")
    public String showForm() {
        return "calculator";
    }

    @RequestMapping("/save-calculator")
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam String operator,
                            Model model) {
        double result = 0;
        String operation = "";
        switch (operator) {
            case "add":
                result = num1 + num2;
                operation = "+";
                break;
            case "subtract":
                result = num1 - num2;
                operation = "-";
                break;
            case "multiply":
                result = num1 * num2;
                operation = "*";
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                    operation = "/";
                } else {
                    model.addAttribute("error", "Cannot divide by zero!");
                    return "calculator";
                }
                break;
            default:
                return "calculator";
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);

        // Trả về view để hiển thị kết quả
        return "result-calculator";
    }
}