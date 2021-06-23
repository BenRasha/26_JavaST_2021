public interface CommandArray {
    /**
     * Returns the sorted array, by the type of sorting request
     * @param request required command from user
     * @return sorted array
     */
    public Array execute(String request);
}
