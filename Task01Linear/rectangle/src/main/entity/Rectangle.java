public class Rectangle {

    /**
     * This is an entity rectangle class with setters, getters and toString() methods.
     * @param length stores length of the rectangle.
     * @param width stores length of the rectangle.
     */

    private double length;
    private double width;

    public Rectangle (double length) {
        this.length = length;
        this.width = length/2;
    }

    public Rectangle (double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
