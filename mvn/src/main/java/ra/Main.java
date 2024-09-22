package ra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập số a: ");
        double a = Double.parseDouble(sc.nextLine());

        System.out.println("Nhập số b: ");
        double b = Double.parseDouble(sc.nextLine());

        System.out.println("Nhập số c: ");
        double c = Double.parseDouble(sc.nextLine());

        QuadraticEquationSolver solver = new QuadraticEquationSolver();
        solver.solve(a, b, c);

        sc.close();
            int age = InputUtil.getInt("Nhập tuổi của bạn: ");
            double height = InputUtil.getDouble("Nhập chiều cao của bạn: ");
            String name = InputUtil.getString("Nhập tên của bạn: ");
            boolean isStudent = InputUtil.getBoolean("Bạn có phải là sinh viên không");

            System.out.println("Thông tin của bạn:");
            System.out.println("Tuổi: " + age);
            System.out.println("Chiều cao: " + height);
            System.out.println("Tên: " + name);
            System.out.println("Là sinh viên: " + (isStudent ? "Có" : "Không"));
    }
}