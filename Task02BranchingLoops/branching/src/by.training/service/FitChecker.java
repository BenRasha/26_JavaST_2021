import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FitChecker {

    static final Logger fitCheckerLogger = LogManager.getLogger(FitChecker.class.getName());

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
