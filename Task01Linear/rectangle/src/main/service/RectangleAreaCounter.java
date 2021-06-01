import java.util.Scanner;

public class RectangleAreaCounter {

    /**
     * Is used to get the user input for the length value.
     * @return double value of users input.
     */

    public double lengthInput () {
        Scanner scanner = new Scanner(System.in);
        double length = 0;
        try {
            length = scanner.nextDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    /**
     * Creates rectangle object and counts it's area: area = (a+b)*2.
     * @return double value which stores area of a created rectangle.
     */

    public double areaCounter (double length) {
        Rectangle rectangle = new Rectangle(length);
        return (rectangle.getLength()+rectangle.getWidth())*2;
    }

}
