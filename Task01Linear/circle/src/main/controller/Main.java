import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());
    private Runner runner = new Runner();
    private double outer;
    private double inner;

    public void correctInputChecker () {
        mainLogger.info("Input outer radius:");
        outer = runner.input();
        mainLogger.info(outer);
        mainLogger.info("Input inner radius");
        inner = runner.input();
        mainLogger.info(inner);
        if (outer < inner) {
            do {
                mainLogger.info("Input outer radius again");
                outer = runner.input();
                mainLogger.info(outer);
            } while (outer < inner);
        }
    }

    public void go () {
        correctInputChecker();
        mainLogger.info("Area of a circle: " + runner.areaCounter(inner,outer));
    }

    public static void main (String [] args) {
        Main main = new Main();
        main.go();
    }
}
