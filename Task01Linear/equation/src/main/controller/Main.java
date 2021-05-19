import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private int x;
    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());

    public int input () {
        int a = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            a = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public int firstAction (int x) {
        return 2*x*x*x*x;
    }

    public int secondAction (int x) {
        return 3*x*x*x;
    }

    public int thirdAction (int x) {
        return 4*x*x;
    }

    public int fourthAction (int x) {
        return 5*x;
    }

    public int wholeAnswer (int x) {
        return firstAction(x) - secondAction(x) + thirdAction(x) - fourthAction(x) + 6;
    }

    public void go () {
        Main main = new Main();
        mainLogger.info("Input x");
        x = main.input();
        mainLogger.info(x);
        mainLogger.info("Answer of the equation: " + main.wholeAnswer(x));
    }

    public static void main (String []args) {
        Main main = new Main();
        main.go();
    }
}
