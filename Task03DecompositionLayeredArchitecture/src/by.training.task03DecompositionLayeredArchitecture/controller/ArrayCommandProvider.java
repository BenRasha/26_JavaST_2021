import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

final class ArrayCommandProvider {

    static final Logger commandProviderLogger = LogManager.getLogger(ArrayCommandProvider.class.getName());

    private final Map<CommandName, CommandArray> repository = new HashMap<>();

    ArrayCommandProvider() {
        repository.put(CommandName.BUBBLE, new BubbleCommandArrayImpl());
        repository.put(CommandName.INSERTION, new InsertionCommandArrayImpl());
        repository.put(CommandName.MERGE, new MergeCommandArrayImpl());
        repository.put(CommandName.SELECTION, new SelectionCommandArrayImpl());
        repository.put(CommandName.SHAKER, new ShakerCommandArrayImpl());
        repository.put(CommandName.SHELL, new ShellCommandArrayImpl());
    }

    /**
     * Provides Command from Map repository, by the name of the command
     * @param name is users input command name
     * @return Command by the provided name
     */

    CommandArray getCommand(String name) {
        CommandName commandName = null;
        CommandArray commandArray = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            commandArray = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            commandProviderLogger.info("Wrong request", e);
            commandArray = repository.get(CommandName.WRONG_REQUEST);
        }
        return commandArray;
    }

}
