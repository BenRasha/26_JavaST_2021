import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Find the area of the circle, inner radius of which is equal to r and outer - R (R > r)
 */

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());
    private CircleCounter circleCounter = new CircleCounter();

    /**
     * Method go() is used to start up the whole application and add information into log file.
     */

    public void go () {
        System.out.print("Input the inner radius of the circle:");
        double inner = circleCounter.input();
        mainLogger.info("The user has inputted: {} as the inner radius of the circle", inner);
        System.out.print("Input the outer radius of the circle:");
        double outer = circleCounter.input();
        mainLogger.info("The user has inputted: {} as the outer radius of the circle", outer);
        mainLogger.info("The area of the circle is equal to: {}", circleCounter.areaCounter(inner, outer));
    }

    public static void main (String [] args) {
        Main main = new Main();
        main.go();
    }
}
