import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserInput {

    static final Logger userInputLogger = LogManager.getLogger(UserInput.class.getName());

    /**
     * Is used to get the user input for the length value.
     * @return double value of users input.
     */

    public int lengthInput () {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        try {
            length = scanner.nextInt();
        } catch (Exception e) {
            userInputLogger.error("Input error!");
        }
        return length;
    }
}
