package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger rootLogger = LogManager.getRootLogger();

    public void go () {
        Runner runner = new Runner();
        rootLogger.info("Input length of a rectangle:");
        double length = runner.lengthInput();
        rootLogger.info(length);
        rootLogger.info(runner.areaCounter(length));
    }

    public static void main (String[] args) {
        Main main = new Main();
        main.go();
    }
}
