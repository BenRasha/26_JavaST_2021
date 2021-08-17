package by.training.Task08XML_WebParsing.controller.impl;

import by.training.Task08XML_WebParsing.controller.command.Command;

public class WrongRequest implements Command {

    @Override
    public String execute(String fileName) {
        return "Can't find such command";
    }

}
