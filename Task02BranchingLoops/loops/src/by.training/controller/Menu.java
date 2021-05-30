import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    /**
     * Creates the whole menu for loops task, which let's user decide which task to complete and logs whole information.
     */

    static final Logger menuLogger = LogManager.getLogger(Menu.class.getName());
    private static final String INFO = "Choose action\n" +
            "1. Count function on a typical section with typical step\n" +
            "2. Count: 1 + 2 + 4 + 8 + ... + 2^10\n" +
            "3. Count function on a typical section with typical step. Result should presented as a table\n" +
            "4. Computer generates five numbers from 1 to 15. Print out all guessed and not numbers\n" +
            "5. In a three digit number the significant digit has been crossed out. After multiplying resulted number" +
            "by 7 we got the same three digit number. Find the number\n" +
            "6. EXIT.";
    private Scanner scanner = new Scanner(System.in);

    /**
     * Outputs info about available options to choose from in an endless loop. Logs information about each task
     * during it's completion.
     */

    public void start() {
        while (true) {
            System.out.println(INFO);
            int actionSelector = scanner.nextInt();
            DataCreator dataCreator = new DataCreator();
            switch (actionSelector) {
                case 1:
                    List<Data> firstTask = dataCreator.createData();
                    FirstTask completer = new FirstTask();
                    for (Data flag : firstTask) {
                        menuLogger.info("With lower border: {}, higher border: {} and step: {}", flag.getLowerBorder(), flag.getHigherBorder(), flag.getStep() + " .Output looks like this:");
                        menuLogger.info("{}", completer.functionCount(flag));
                    }
                    break;
                case 2:
                    SecondTask secondTask = new SecondTask();
                    menuLogger.info("Answer: {}", secondTask.doCount());
                    break;
                case 3:
                    List<Data> thirdTask = dataCreator.createData();
                    ThirdTask thrdTask = new ThirdTask();
                    for (Data flag : thirdTask) {
                        for (int i = flag.getLowerBorder(); i < flag.getHigherBorder(); i += flag.getStep()) {
                            menuLogger.info("Argument: {}, Function: {}", i, thrdTask.count(i).get(i));
                        }
                    }
                    break;
                case 4:
                    NumbersGenerator numbersGenerator = new NumbersGenerator();
                    List<Integer> generated = numbersGenerator.generate();
                    InputAnalyzer inputAnalyzer = new InputAnalyzer();
                    List<Integer> inputted = inputAnalyzer.userInput();
                    menuLogger.info("Numbers inputted: {}", inputted);
                    menuLogger.info("Numbers that were generated: {}", generated);
                    menuLogger.info("Numbers guessed: {}, numbers not guessed: {}", inputAnalyzer.numbersAreEqualCheck(inputted,generated), generated);
                    inputted.clear();
                    generated.clear();
                    break;
                case 5:
                    FifthTask fifthTask = new FifthTask();
                    menuLogger.info("Number we're searching for: {}", fifthTask.numbersFinder());
                    break;
                case 6:
                    menuLogger.info("User decided to quit");
                    System.exit(0);
                default:
                    menuLogger.info("No such case!");
                    System.out.print("No such case!");
                    break;
            }
        }
    }
}
