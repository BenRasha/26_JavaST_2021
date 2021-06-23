public interface CommandMatrix {
    /**
     * Completes the task on matrix
     * @param request required command from user on matrix
     * @return matrix, after task completion
     */
    public Matrix execute(String request);
}
