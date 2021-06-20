import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    static final Logger commandProviderLogger = LogManager.getLogger(CommandProvider.class.getName());
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.CHANGE_WHEEL, new ChangeWheelImpl());
        repository.put(CommandName.CHARGE_ENGINE, new ChargeEngineImpl());
        repository.put(CommandName.DRIVE_AUTOMOBILE, new DriveAutomobileImpl());
        repository.put(CommandName.SHOW_BRAND, new ShowBrandImpl());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        CreateAutomobile.createAutomobile();
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            commandProviderLogger.info("Wrong request", e);
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
