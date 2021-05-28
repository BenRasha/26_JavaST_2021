import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FitChecker {

    static final Logger fitCheckerLogger = LogManager.getLogger(FitChecker.class.getName());

    /**
     * Used to create a hole, length and width of which are provided by the user
     * @return int array with two parameters
     */

    public int[] createHole() {
        int []hole = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of a whole:");
        hole[0] = scanner.nextInt();
        fitCheckerLogger.info("User has inputted {} as length of a hole", hole[0]);
        if (hole[0] < 0) {
            throw new IllegalArgumentException();
        }
        System.out.print("Input width of a whole:");
        hole[1] = scanner.nextInt();
        fitCheckerLogger.info("User has inputted {} as width of a hole", hole[1]);
        if (hole[1] < 0) {
            throw new IllegalArgumentException();
        }
        return hole;
    }

    /**
     * Used in task four in branching to check whether brick fits the whole
     * @param data object from which we get all the parameters of the brick
     * @param length is length of the hole used in comparison process
     * @param width is width of the hole used in comparison process
     * @return true if brick fits into a hole, and false if not
     */

    public boolean checkWhetherBrickFits (Data data, int length, int width) {
        if ( ( length >= data.getX() && width >= data.getA() ) || ( length >= data.getA() && width >= data.getX() ) ) {
            return true;
        } else if ( ( length >= data.getX() && width >= data.getB() ) || ( length >= data.getB() && width >= data.getX() ) ) {
            return true;
        } else if ( (length >= data.getB() && width >= data.getA()) || (length >= data.getA() && width >= data.getB() ) ) {
            return true;
        } else {
            return false;
        }
    }
}
