package ra;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    // Phương thức nhập số nguyên
    public static int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập lại số nguyên.");
            }
        }
    }

    // Phương thức nhập số thực
    public static double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập lại số thực.");
            }
        }
    }

    // Phương thức nhập chuỗi không rỗng
    public static String getString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Chuỗi không được để trống, vui lòng nhập lại.");
            }
        }
    }

    // Phương thức nhập boolean (yes/no)
    public static boolean getBoolean(String message) {
        while (true) {
            System.out.print(message + " (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập 'yes' hoặc 'no'.");
            }
        }
    }
}