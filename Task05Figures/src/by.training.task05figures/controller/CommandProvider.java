import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    static final Logger commandProviderLogger = LogManager.getLogger(CommandProvider.class.getName());
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.CREATE_PYRAMID, new CreatePyramidImpl());
        repository.put(CommandName.COUNT_AREA, new CountAreaImpl());
        repository.put(CommandName.COUNT_CAPACITY, new CountCapacityImpl());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException exception) {
            commandProviderLogger.error("Error during finding command", exception);
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
