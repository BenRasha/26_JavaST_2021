import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.CHANGE_WHEEL, new ChangeWheelImpl());
        repository.put(CommandName.CHARGE_ENGINE, new ChargeEngineImpl());
        repository.put(CommandName.DRIVE_AUTOMOBILE, new DriveAutomobileImpl());
        repository.put(CommandName.SHOW_BRAND, new ShowBrandImpl());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        boolean commandSearch = false;
        for (CommandName flag : CommandName.values()) {
            if (flag.getInternationalNames().contains(name)) {
                commandName = flag;
                commandSearch = true;
            }
        }
        command = commandSearch ? repository.get(commandName) : repository.get(CommandName.WRONG_REQUEST);
        return command;
    }

}
