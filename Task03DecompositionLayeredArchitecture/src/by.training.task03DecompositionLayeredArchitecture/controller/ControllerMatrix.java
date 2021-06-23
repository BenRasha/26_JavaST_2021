public class ControllerMatrix {

    private final MatrixCommandProvider provider = new MatrixCommandProvider();
    private static final char PARAM_DELIMETER = ' ';

    /**
     * Reads user input and executes command from the Map repository of the Matrix Command Provider
     * @param request users input of what he wants
     * @return result of command completion
     */

    public Matrix executeTask(String request) {
        Matrix matrix;
        String commandName;
        CommandMatrix executionCommandMatrix;
        commandName = request.substring(0, request.indexOf(PARAM_DELIMETER));
        executionCommandMatrix = provider.getCommand(commandName);
        matrix = executionCommandMatrix.execute(request);
        return matrix;
    }
}
