import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());

    public void go () {
        Runner runner = new Runner();
        mainLogger.info("Input length of a rectangle:");
        double length = runner.lengthInput();
        mainLogger.info(length);
        mainLogger.info("Area of rectangle: " + runner.areaCounter(length));
    }

    public static void main (String[] args) {
        Main main = new Main();
        main.go();
    }
}
