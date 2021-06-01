import java.util.Scanner;

public class CircleCounter {

    /**
     * Method input() is used to get the input from the user.
     * @return double value of the user input.
     */

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

    /**
     * Creates the circle object and counts the circle area: S = pi * (R^2 - r^2).
     * @param inner is the inner radius of the circle object.
     * @param outer is the outer radius of the circle object.
     * @return double value of the counted area.
     */

    public double areaCounter (double inner, double outer) {
        Circle circle = new Circle(inner,outer);
        return 3.14*(Math.pow(circle.getOuterRadius(),2)-Math.pow(circle.getInnerRadius(), 2));
    }
}
