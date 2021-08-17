package by.training.Task08XML_WebParsing.controller;

import by.training.Task08XML_WebParsing.controller.command.Command;

public class Controller {

    private CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request, String fileName) {
        String commandName;
        Command executableCommand;
        commandName = request;
        executableCommand = commandProvider.getCommand(commandName);
        return executableCommand.execute(fileName);
    }

}
