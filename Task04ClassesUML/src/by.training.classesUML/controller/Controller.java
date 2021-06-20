public class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        String response;
        String commandName;
        Command executeCommand;
        commandName = request;
        executeCommand = provider.getCommand(commandName);
        response = executeCommand.execute(request);
        return response;
    }

}
