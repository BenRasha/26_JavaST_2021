public final class Controller {

    private final CommandProvider provider = new CommandProvider();
    private final char paramDelimiter = ' ';

    /**
     * Reads user input and executes command from the Map repository of the Command Provider
     * @param request users input of what he wants
     * @return result of command completion
     */

    public String executeTask(String request) {
        String response;
        String commandName;
        Command executionCommand;
        commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.getCommand(commandName);
        response = executionCommand.execute(request);
        return response;
    }
}
