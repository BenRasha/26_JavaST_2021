public class Circle {

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
