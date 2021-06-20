import java.util.Scanner;

public class Runner {

    private static final String INFO = "Choose from following options\n" +
            "1.Change_Wheel\n" +
            "2.Charge_Engine\n" +
            "3.Show_Brand\n" +
            "4.Drive_Automobile\n" +
            "5.Exit";

    public void go() {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        String request = null;
        boolean startMenu = true;
        while (startMenu) {
            System.out.println(INFO);
            request = scanner.nextLine().toLowerCase();
            if (request.equals("exit")) {
                startMenu = false;
            } else {
                System.out.println(controller.executeTask(request));
            }
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.go();
    }
}
