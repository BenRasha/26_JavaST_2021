import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Find the area of the circle, inner radius of which is equal to r and outer - R (R > r)
 */

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());
    private CircleCounter circleCounter = new CircleCounter();
    private UserInput userInput = new UserInput();

    /**
     * Method go() is used to start up the whole application and add information into log file.
     */

    public void go () {
        System.out.print("Input the inner radius of the circle:");
        double inner = userInput.lengthInput();
        mainLogger.info("The user has inputted: {} as the inner radius of the circle", inner);
        System.out.print("Input the outer radius of the circle:");
        double outer = userInput.lengthInput();
        mainLogger.info("The user has inputted: {} as the outer radius of the circle", outer);
        mainLogger.info("The area of the circle is equal to: {}", circleCounter.areaCounter(inner, outer));
    }

    public static void main (String [] args) {
        Main main = new Main();
        main.go();
    }
}
