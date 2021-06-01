import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserInput {

    static final Logger userInputLogger = LogManager.getLogger(UserInput.class.getName());

    /**
     * Is used to get the user input for the length value.
     * @return int value of users input.
     */

    public double lengthInput () {
        Scanner scanner = new Scanner(System.in);
        double length = 0;
        try {
            length = scanner.nextDouble();
        } catch (Exception e) {
            userInputLogger.error("Input error!");
        }
        return length;
    }
}
