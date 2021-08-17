package by.training.Task08XML_WebParsing.controller;

import by.training.Task08XML_WebParsing.controller.command.Command;
import by.training.Task08XML_WebParsing.controller.command.CommandName;
import by.training.Task08XML_WebParsing.controller.impl.DomPrinter;
import by.training.Task08XML_WebParsing.controller.impl.SaxPrinter;
import by.training.Task08XML_WebParsing.controller.impl.StaxPrinter;
import by.training.Task08XML_WebParsing.controller.impl.WrongRequest;
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
