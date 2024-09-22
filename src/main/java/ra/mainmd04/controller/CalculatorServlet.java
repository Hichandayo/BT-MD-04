package ra.mainmd04.controller;

import ra.mainmd04.Calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operand1Str = request.getParameter("operand1");
        String operand2Str = request.getParameter("operand2");
        String operator = request.getParameter("operator");

        double operand1 = Double.parseDouble(operand1Str);
        double operand2 = Double.parseDouble(operand2Str);
        Calculator calculator = new Calculator();
        String result;
        String expression;

        try {
            double calculationResult = calculator.calculate(operand1, operand2, operator);
            result = String.format("%.2f", calculationResult);
            expression = String.format("%.2f %s %.2f = %s", operand1, operator, operand2, result);
        } catch (ArithmeticException e) {
            result = "Lỗi: " + e.getMessage();
            expression = "";
        } catch (NumberFormatException e) {
            result = "Lỗi: Vui lòng nhập số hợp lệ";
            expression = "";
        } catch (IllegalArgumentException e) {
            result = "Lỗi: " + e.getMessage();
            expression = "";
        }

        request.setAttribute("result", result);
        request.setAttribute("expression", expression);
        request.getRequestDispatcher("/views/result.jsp").forward(request, response);
    }
}