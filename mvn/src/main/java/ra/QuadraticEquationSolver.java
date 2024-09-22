package ra;

public class QuadraticEquationSolver {
    public void solve(double a, double b, double c){
        if (a == 0){
            System.out.println("Không phải phương trình bậc hai");
        }
        double delta = b * b -4 * a * c;
        if (delta < 0){
            System.out.println("Phương trình vô nghiệm");
        }else if(delta == 0){
            double x = -b / (2 * a);
            System.out.println("Nghiệm kép x = " + x);
        }else{
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phương trình có hai nghiệm phân biệt: ");
            System.out.println("Nghiệm x1 = " + x1);
            System.out.println("Nghiệm x2 = " + x2);
        }
    }
}
