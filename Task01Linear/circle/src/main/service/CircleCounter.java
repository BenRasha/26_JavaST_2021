public class CircleCounter {

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
