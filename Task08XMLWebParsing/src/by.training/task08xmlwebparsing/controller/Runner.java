package controller;

import java.util.Scanner;

public class Runner {

    private static final String MENU_INFO = "Select type of parsing\n"
            + "1. DOM\n"
            + "2. StAx\n"
            + "3. SAX\n"
            + "4. Exit\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        String fileName = "src/by.training/resources/edition.xml";
        boolean startMenu = true;
        while (startMenu) {
            System.out.println(MENU_INFO);
            int actionSelector = scanner.nextInt();
            switch (actionSelector) {
                case 1:
                    System.out.println(controller.executeTask("dom", fileName));
                    break;
                case 2:
                    System.out.println(controller.executeTask("stax", fileName));
                    break;
                case 3:
                    System.out.println(controller.executeTask("sax", fileName));
                    break;
                case 4:
                    startMenu = false;
                    break;
                default:
                    System.out.println("You have chosen wrong command");
            }
        }
    }
}
