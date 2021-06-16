import java.util.Scanner;

public class Runner {

    private static final String ARRAY_INFO = "Input type of sorting and increasing or decreasing separated by space\n" +
            "input exit to return to start menu.\n";
    private static final String INFO = "Choose from three options:\n" +
            "arrays -  Arrays and sorting.\n" +
            "matrix -  Matrices and operations with them (multiplying, subdividing, sum).\n" +
            "exit -  EXIT.\n";
    private static final String MATRIX_INFO = "Input multiply/sum/subdivide matrix or exit to return to start menu\n";

    private void go() {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        String request = null;
        boolean startMenu = true;
        while (startMenu) {
            System.out.print(INFO);
            String actionSelector = scanner.nextLine().toLowerCase().trim();
            switch (actionSelector) {
                case "arrays":
                    boolean arrayFlag = true;
                    while (arrayFlag) {
                        System.out.print(ARRAY_INFO);
                        request = scanner.nextLine().toLowerCase().trim();
                        if (request.equals("exit")) {
                            arrayFlag = false;
                        } else {
                            System.out.println(controller.executeTask(request));
                        }
                    }
                    break;
                case "matrix":
                    boolean matrixFlag = true;
                    while (matrixFlag) {
                        System.out.print(MATRIX_INFO);
                        request = scanner.nextLine().toLowerCase().trim();
                        if (request.equals("exit")) {
                            matrixFlag = false;
                        } else {
                            System.out.println(controller.executeTask(request));
                        }
                    }
                    break;
                case "exit":
                    startMenu = false;
                    break;
                default:
                    System.out.println("No such case!");
            }
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.go();
    }
}
