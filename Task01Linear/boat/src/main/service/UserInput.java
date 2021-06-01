import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserInput {

    static final Logger userInputLogger = LogManager.getLogger(UserInput.class.getName());

    /**
     * Is used to get the user input for the length value.
     * @return int value of users input.
     */

    public int[] parametersInput() {
        Scanner scanner = new Scanner(System.in);
        int param[] = new int[4];
        try {
            for (int i = 0; i < 4; i++) {
                param[i] = scanner.nextInt();
            }
        } catch (Exception e) {
            userInputLogger.error("Input error!");
        }
        return param;
    }
}
