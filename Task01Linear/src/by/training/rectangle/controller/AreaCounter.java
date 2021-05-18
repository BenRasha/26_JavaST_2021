package controller;

import entity.Rectangle;

public class AreaCounter {

    public int areaCounter (int input) {
        Rectangle rectangle = new Rectangle(input);
        return (rectangle.getLength()+rectangle.getWidth())*2;
    }
}
