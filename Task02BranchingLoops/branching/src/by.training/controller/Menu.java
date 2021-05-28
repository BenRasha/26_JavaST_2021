import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static final Logger menuLogger = LogManager.getLogger(Menu.class.getName());
    private static final String INFO = "Choose action\n" +
            "1. Create a program, which finds a module of following equation a*x*x + b*x + c.\n" +
            "2. Given two real numbers not equal to each other. Replace lower number with half of their sum and biggest number with doubled multiplication.\n" +
            "3. Check, whether inputted date is correct. If not, print a message.\n" +
            "4. Given a size of rectangle type hole and a size of a brick. Find whether brick fits in a hole.\n" +
            "5. Count the equation -x^2 + x - 9(x>=8), 1/x^4-6(x<8).\n" +
            "6. EXIT.";
    Scanner scanner = new Scanner(System.in);

    /**
     * Endless cycle menu, which let's user choose from 5 tasks.
     * @throws NumbersException custom exception with constructor that's parsing String message.
     */

    public void go () throws NumbersException {
        while (true) {
            System.out.println(INFO);
            int actionSelector = scanner.nextInt();
            FileOpener fileOpener = new FileOpener();
            switch (actionSelector) {
                case 1:
                    FirstDataCreator firstDataCreator = new FirstDataCreator();
                    ArrayList<Data> data = firstDataCreator.createData(fileOpener);
                    ModFinder modFinder = new ModFinder();
                    for (Data flag : data) {
                        menuLogger.info("With provided {} as x, answer of the equation: {}", flag.getX(), modFinder.modCounter(flag));
                    }
                    break;
                case 2:
                   SecondDataCreator secondDataCreator = new SecondDataCreator();
                   ArrayList<Data> secondTask = secondDataCreator.createData(fileOpener);
                    ArithmeticCompiler arithmeticCompiler = new ArithmeticCompiler();
                   for (Data flag : secondTask) {
                       menuLogger.info("We were given {} as an x and {} as y", flag.getX(), flag.getA());
                       arithmeticCompiler.numberReplacer(flag);
                       menuLogger.info("After method numberReplacer(Data data) has been invoked numbers look this: {}  {}",flag.getX(), flag.getA());
                   }
                   break;
                case 3:
                    ThirdDataCreator thirdDataCreator = new ThirdDataCreator();
                    ArrayList<Data> thirdTask = thirdDataCreator.createData(fileOpener);
                    for (Data flag : thirdTask) {
                        menuLogger.info("Day: {}, Month: {}", flag.getX(), flag.getA());
                    }
                    break;
                case 4:
                    FourthDataCreator fourthDataCreator = new FourthDataCreator();
                    ArrayList<Data> fourthTask = fourthDataCreator.createData(fileOpener);
                    FitChecker fitChecker = new FitChecker();
                    int hole[] = fitChecker.createHole();
                    for (Data flag : fourthTask) {
                        if (fitChecker.checkWhetherBrickFits(flag, hole[0], hole[1])) {
                            menuLogger.info("x: {}, y: {}, z: {}: This brick fits in a hole",flag.getX(), flag.getA(), flag.getB());
                        } else {
                            menuLogger.info("x: {}, y: {}, z: {}: This brick doesn't fit in a hole",flag.getX(), flag.getA(), flag.getB());
                        }
                    }
                    break;
                case 5:
                    FifthDataCreator fifthDataCreator = new FifthDataCreator();
                    ArrayList<Data> fifthTask = fifthDataCreator.createData(fileOpener);
                    EquationCounter equationCounter = new EquationCounter();
                    for (Data flag : fifthTask) {
                        menuLogger.info("With {} provided as x, answer of the equation: {}", flag.getX(), equationCounter.countEquation(flag));
                    }
                    break;
                case 6:
                    menuLogger.info("User pressed 6 to quit");
                    System.exit(0);
                    break;
                default:
                    menuLogger.error("No such case!");
                    System.out.println("No such case!");
            }
        }
    }
}
