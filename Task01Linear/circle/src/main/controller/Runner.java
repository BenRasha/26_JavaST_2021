import java.util.Scanner;

public class Runner {

    public double input () {
        Scanner scanner = new Scanner(System.in);
        double a = 0.0;
        try {
            a = scanner.nextDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public double areaCounter (double inner, double outer) {
        Circle circle = new Circle(inner,outer);
        return 3.14*(Math.pow(circle.getOuterRadius(),2)-Math.pow(circle.getInnerRadius(), 2));
    }
}
