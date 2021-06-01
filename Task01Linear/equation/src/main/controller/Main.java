import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

/**
 * Given a real number x, using no other arithmetic operations than multiplication, addition and subtraction
 * count next: 2x^4 - 3x^3 + 4x^2 - 5x + 6.-
 */

public class Main {

    static final Logger mainLogger = LogManager.getLogger(Main.class.getName());
    Scanner scanner = new Scanner(System.in);
    Counter counter = new Counter();

    /**
     * Is used to get the x from the user and count the answer of the equation.
     */

    public void go() {
        System.out.println("Input the x: ");
        int x = scanner.nextInt();
        mainLogger.info("The user has entered {} as x", x);
        mainLogger.info("Answer of the equation is: {}", counter.wholeAnswer(x));
    }

    public static void main (String []args) {
        Main main = new Main();
        main.go();
    }
}
