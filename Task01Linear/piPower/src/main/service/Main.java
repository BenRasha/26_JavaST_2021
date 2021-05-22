import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Write a program, which prints on the screen first four powers of the PI.
 */

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());

    /**
     * Method go() is used to start up the whole application and write information into logger.
     */

    public void go() {
        for (int i = 0; i < 5; i++) {
            mainLogger.info("PI elevated in {} is equal to: {}", i, Runner.piElevator(i));
        }
    }

    public static void main(String []args) {
        Main main = new Main();
        main.go();
    }
}
