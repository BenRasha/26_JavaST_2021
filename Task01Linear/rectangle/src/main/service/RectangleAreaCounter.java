public class RectangleAreaCounter {

    /**
     * Creates rectangle object and counts it's area: area = (a+b)*2.
     * @return double value which stores area of a created rectangle.
     */

    public double areaCounter (double length) {
        Rectangle rectangle = new Rectangle(length);
        return (rectangle.getLength()+rectangle.getWidth())*2;
    }

}
