package controller;

import entity.Rectangle;

import java.util.Scanner;

public class Runner {

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

    public double areaCounter (double length) {
        Rectangle rectangle = new Rectangle(length);
        return (rectangle.getLength()+rectangle.getWidth())*2;
    }
}
