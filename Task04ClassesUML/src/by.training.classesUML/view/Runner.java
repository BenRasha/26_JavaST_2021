import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    private MessageManager messageManager;
    static final Logger runnerLogger = LogManager.getLogger(Runner.class.getName());

    private void languageSelection() {
        System.out.println("1.Ru\n2.En\ninvalid input - En");
        Scanner intScanner = new Scanner(System.in);
        try {
            int action = intScanner.nextInt();
            switch (action) {
                case 1:
                    messageManager = MessageManager.RU;
                    break;
                case 2:
                    messageManager = MessageManager.EN;
                    break;
                default:
                    messageManager = MessageManager.EN;
                    break;
            }
        } catch (InputMismatchException e) {
            runnerLogger.info("Illegal form of input", e);
        }
        Locale.setDefault(messageManager.getBundle().getLocale());
        System.out.println(messageManager.getString("menu.options"));
    }

    private void go(){
        languageSelection();
        Controller controller = new Controller();
        System.out.println(messageManager.getString("go.start"));
        CreateAutomobile createAutomobile = new CreateAutomobile();
        Automobile automobile;
        automobile = createAutomobile.createAutomobile();
        System.out.println(automobile.toString());
        boolean flag = true;
        String request = "";
        Scanner stringScanner = new Scanner(System.in);
        while (flag) {
            request = stringScanner.nextLine().toLowerCase().trim();
            if (request.equals(messageManager.getString("exit"))) {
                flag = false;
            } else if (request.equals(messageManager.getString("change_locale"))) {
                languageSelection();
            } else {
                System.out.println(controller.executeTask(request, automobile));
            }
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.go();
    }
}
