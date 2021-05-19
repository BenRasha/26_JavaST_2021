import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());

    public void go () {
        Runner runner = new Runner();
        mainLogger.info("Input speed of the boat");
        int boatSpeed = runner.input();
        mainLogger.info(boatSpeed);
        mainLogger.info("Input speed of the flow of the river");
        int rvrSpd = runner.input();
        mainLogger.info(rvrSpd);
        mainLogger.info("Input time of the boat in a lake");
        int lkTime = runner.input();
        mainLogger.info(lkTime);
        mainLogger.info("Input time, which took boat to travel against the flow");
        int agnstFlwTm = runner.input();
        mainLogger.info(agnstFlwTm);
        mainLogger.info(runner.wayCounter(boatSpeed,rvrSpd,lkTime,agnstFlwTm));
    }

    public static void main (String []args) {
        Main main = new Main();
        main.go();
    }
}
