public class EquationCounter {

    public int countEquation (Data data) {
        if (data.getX() < 8) {
            return (int) (1 / (Math.pow(data.getX(), 4) - 6));
        } else {
            return (int) (data.getX() - Math.pow(data.getX(), 2) - 9);
        }
    }
}
