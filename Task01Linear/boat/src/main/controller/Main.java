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
        System.out.print("Input speed of the boat: ");
        int boatSpeed = boatWayCounter.input();
        mainLogger.info("The user has entered {}km/h as the speed of the boat", boatSpeed);
        System.out.print("Input speed of the flow of the river: ");
        int rvrSpd = boatWayCounter.input();
        mainLogger.info("The user has entered {}km/h as the speed of the river flow", rvrSpd);
        System.out.print("Input time of the boat in a lake: ");
        int lkTime = boatWayCounter.input();
        mainLogger.info("The user has entered {}h as the time of the boat in a lake", lkTime);
        System.out.print("Input time, which took boat to travel against the flow: ");
        int agnstFlwTm = boatWayCounter.input();
        mainLogger.info("The user has entered {}h as the time, which boat travelled against the river flow", agnstFlwTm);
        mainLogger.info("The whole way of the boat: {}", boatWayCounter.wayCounter(boatSpeed,rvrSpd,lkTime,agnstFlwTm));
    }

    public static void main (String []args) {
        Main main = new Main();
        main.go();
    }
}
