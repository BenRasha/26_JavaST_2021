import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CreateAutomobile {

    public static Automobile automobile;
    static final Logger createAutomobileLogger = LogManager.getLogger(CreateAutomobile.class.getName());

    private CreateAutomobile() {}

    public static void createAutomobile() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        GenerateToFileThenRead<Wheel> wheelGenerator = serviceFactory.getWheelGenerateThenReadGenerator();
        GenerateToFileThenRead<Engine> engineGenerator = serviceFactory.getEngineGenerateToFileThenRead();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        try {
            List<Wheel> wheels = wheelGenerator.generateThenRead();
            Engine engine = engineGenerator.generateThenRead().get(0);
            automobile = automobileCreator.createAutomobile(wheels, engine);
        } catch (ServiceException e) {
            createAutomobileLogger.info("Error during creating automobile");
        }
    }

}
