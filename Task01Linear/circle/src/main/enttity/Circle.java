public class Circle {

    /**
     * This is an entity circle class with setter, getters and toString() methods.
     * @param innerRadius stores the double value of inner radius of the circle.
     * @param outerRadius stores the double value of outer radius of the circle.
     */

    private double innerRadius;
    private double outerRadius;

    public Circle (double innerRadius, double outerRadius) {
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "innerRadius=" + innerRadius +
                ", outerRadius=" + outerRadius +
                '}';
    }
}
