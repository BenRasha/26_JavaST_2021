import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * You are given rectangle, width of which is half of the length. Find the area of the rectangle.
 */

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());

    /**
     * Method go() used to start up the whole application and add information into log file.
     */

    public void go () {
        RectangleAreaCounter rectangleAreaCounter = new RectangleAreaCounter();
        UserInput userInput = new UserInput();
        System.out.println("Input length of a rectangle:");
        double length = userInput.lengthInput();
        mainLogger.info("The user has inputted: {} as the length of a rectangle.", length);
        mainLogger.info("Area of rectangle: {}", rectangleAreaCounter.areaCounter(length));
    }

    public static void main (String[] args) {
        Main main = new Main();
        main.go();
    }
}
