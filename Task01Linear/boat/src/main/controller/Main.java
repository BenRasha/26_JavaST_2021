import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Create a program to calculate the distanced traveled by a boat, if it's own speed is v km/h, speed of the river flow
 *  v1 km/h, the time of movement in a lake t1 h, time of movement against the river flow - t2 h.
 */

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());

    /**
     * Method go() is used to get all the necessary inputs from the user, count the way and put info into log.
     */

    public void go () {
        BoatWayCounter boatWayCounter = new BoatWayCounter();
        UserInput userInput = new UserInput();
        System.out.println("Input speed of the boat, speed of the flow, time of boat in a lake, time, which took boat to travel" +
                "against the flow: ");
        int[] boatParameters = userInput.parametersInput();
        mainLogger.info("The whole way of the boat: {}", boatWayCounter.wayCounter(boatParameters));
    }

    public static void main (String []args) {
        Main main = new Main();
        main.go();
    }
}
