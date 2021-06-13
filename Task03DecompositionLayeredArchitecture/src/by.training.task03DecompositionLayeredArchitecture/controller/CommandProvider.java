import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    static final Logger commandProviderLogger = LogManager.getLogger(CommandProvider.class.getName());

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.BUBBLE, new BubbleCommandImpl());
        repository.put(CommandName.INSERTION, new InsertionCommandImpl());
        repository.put(CommandName.MERGE, new MergeCommandImpl());
        repository.put(CommandName.SELECTION, new SelectionCommandImpl());
        repository.put(CommandName.SHAKER, new ShakerCommandImpl());
        repository.put(CommandName.SHELL, new ShellCommandImpl());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.MULTIPLY, new MultiplyCommandImpl());
        repository.put(CommandName.SUM, new SummatorCommandImpl());
        repository.put(CommandName.SUBDIVIDE, new SubdividerCommandImpl());
    }

    /**
     * Provides Command from Map repository, by the name of the command
     * @param name is users input command name
     * @return Command by the provided name
     */

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
