package controller.impl;

import controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String fileName) {
        return "Can't find such command";
    }
}
