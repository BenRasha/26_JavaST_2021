public class Controller {

    private final CommandProvider commandProvider = new CommandProvider();

    public double executeTask(String request, Pyramid pyramid) {
        String commandName = request;
        Command executionCommand;
        executionCommand = commandProvider.getCommand(commandName);
        return executionCommand.execute(request, pyramid);
    }

}
