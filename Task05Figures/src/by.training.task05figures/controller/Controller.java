public class Controller {

    private final CommandProvider commandProvider = new CommandProvider();

    public Pyramid executeTask(String request) {
        Pyramid pyramid;
        String commandName = request;
        Command executionCommand;
        executionCommand = commandProvider.getCommand(commandName);
        pyramid = executionCommand.execute(request);
        return pyramid;
    }

}
