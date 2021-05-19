import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Runner {

    static final Logger runnerLogger = LogManager.getLogger(Runner.class.getName());

    public static void main (String[] args) {
        for (int i = 0;i < 5; i++) {
            runnerLogger.info(Math.pow(Math.PI,i));
        }
    }
}
