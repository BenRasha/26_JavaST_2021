package controller;

import java.util.Scanner;

public class Main {

    public void go () {
        Scanner scanner = new Scanner(System.in);
        AreaCounter areaCounter = new AreaCounter();
        System.out.print("Input rectangles length:");
        System.out.println(areaCounter.areaCounter(scanner.nextInt()));
    }

    public static void main (String[] args) {
        Main main = new Main();
        main.go();
    }
}
