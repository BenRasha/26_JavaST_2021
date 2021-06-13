public interface Command {
    /**
     * Returns the answer to users request in String format
     * @param request required command from user
     * @return result of the command completion
     */
    public String execute(String request);
}
