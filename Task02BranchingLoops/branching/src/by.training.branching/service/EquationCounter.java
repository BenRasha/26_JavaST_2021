public class EquationCounter {

    /**
     * Used to complete the fifth task in branching
     * @param data object, from which we get the number to count the answer
     * @return int result of arithmetic operations, the choice of which depends on the magnitude of the number
     */

    public int countEquation (Data data) {
        if (data.getX() < 8) {
            return (int) (1 / (Math.pow(data.getX(), 4) - 6));
        } else {
            return (int) (data.getX() - Math.pow(data.getX(), 2) - 9);
        }
    }
}
