package controller;

import controller.command.Command;
import controller.command.CommandName;
import controller.impl.DomPrinter;
import controller.impl.SaxPrinter;
import controller.impl.StaxPrinter;
import controller.impl.WrongRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    static final Logger commandProviderLogger = LogManager.getLogger(CommandProvider.class.getName());
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.DOM, new DomPrinter());
        repository.put(CommandName.SAX, new SaxPrinter());
        repository.put(CommandName.STAX, new StaxPrinter());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException exception) {
            commandProviderLogger.error(exception);
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
