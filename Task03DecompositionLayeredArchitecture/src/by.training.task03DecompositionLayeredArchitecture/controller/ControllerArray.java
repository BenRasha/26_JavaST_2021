public final class ControllerArray {

    private final ArrayCommandProvider provider = new ArrayCommandProvider();
    private static final char PARAM_DELIMETER = ' ';

    /**
     * Reads user input and executes command from the Map repository of the Command Provider
     * @param request users input of what he wants
     * @return result of command completion
     */

    public Array executeTask(String request) {
        Array array;
        String commandName;
        CommandArray executionCommandArray;
        commandName = request.substring(0, request.indexOf(PARAM_DELIMETER));
        executionCommandArray = provider.getCommand(commandName);
        array = executionCommandArray.execute(request);
        return array;
    }
}
