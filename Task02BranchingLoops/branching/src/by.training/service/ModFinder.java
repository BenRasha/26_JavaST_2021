public class ModFinder {

    /**
     * Used in task one of branching to find module of the equation
     * @param data object from which we get all necessary elements
     * @return module of the calculations
     */

    public int modCounter (Data data) {
        return Math.abs(data.getA() * data.getX() * data.getX() + data.getB() * data.getX() + data.getC());
    }
}
