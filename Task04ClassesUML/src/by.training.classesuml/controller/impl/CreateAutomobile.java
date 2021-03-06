import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CreateAutomobile{

    static final Logger createAutomobileLogger = LogManager.getLogger(CreateAutomobile.class.getName());

    public Automobile createAutomobile() {
        Automobile automobile = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        GenerateToFileThenRead<Wheel> wheelGenerator = serviceFactory.getWheelGenerateThenReadGenerator();
        GenerateToFileThenRead<Engine> engineGenerator = serviceFactory.getEngineGenerateToFileThenRead();
        AutomobileService automobileService = serviceFactory.getAutomobileCreator();
        try {
            List<Wheel> wheels = wheelGenerator.generateThenRead();
            List<Engine> engines = engineGenerator.generateThenRead();
            automobile = automobileService.createAutomobile(wheels, engines.get(0));
        } catch (ServiceException e) {
            createAutomobileLogger.error("Error during creating automobile", e);
        }
        return automobile;
    }
}
