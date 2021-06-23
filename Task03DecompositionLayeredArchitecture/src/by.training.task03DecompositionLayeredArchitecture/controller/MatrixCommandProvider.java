import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MatrixCommandProvider {

    static final Logger commandProviderLogger = LogManager.getLogger(MatrixCommandProvider.class.getName());

    private final Map<CommandName, CommandMatrix> repository = new HashMap<>();

    MatrixCommandProvider() {
        repository.put(CommandName.MULTIPLY, new MultiplyCommandArrayImpl());
        repository.put(CommandName.SUBDIVIDE, new SubdividerCommandArrayImpl());
        repository.put(CommandName.SUM, new SummatorCommandArrayImpl());
    }

    /**
     * Provides Command from Map repository, by the name of the command
     * @param name is users input command name
     * @return Command by the provided name
     */

    CommandMatrix getCommand(String name) {
        CommandName commandName = null;
        CommandMatrix commandMatrix = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            commandMatrix = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            commandProviderLogger.info("Wrong request", e);
            commandMatrix = repository.get(CommandName.WRONG_REQUEST);
        }
        return commandMatrix;
    }

}
