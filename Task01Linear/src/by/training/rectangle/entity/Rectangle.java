package entity;

public class Rectangle {

    private int length;
    private int width;

    public Rectangle (int length) {
        this.length = length;
        this.width = length/2;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
