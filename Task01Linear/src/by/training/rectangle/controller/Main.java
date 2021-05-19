package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger runnerLogger = LogManager.getLogger(Main.class.getName());

    public void go () {
        Runner runner = new Runner();
        runnerLogger.info("Input length of a rectangle:");
        double length = runner.lengthInput();
        runnerLogger.info(length);
        runnerLogger.info(runner.areaCounter(length));
    }

    public static void main (String[] args) {
        Main main = new Main();
        main.go();
    }
}
