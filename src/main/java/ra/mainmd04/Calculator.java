package ra.mainmd04;

public class Calculator {

    public double calculate(double operand1, double operand2, String operator) throws ArithmeticException {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Không thể chia cho 0");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Toán tử không hợp lệ");
        }
    }
}
