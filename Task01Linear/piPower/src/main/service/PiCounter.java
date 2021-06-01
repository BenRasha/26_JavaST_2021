public class PiCounter {

    private static final double PI = 3.14;

    /**
     * Elevates constant PI into provided power.
     * @param power provides power, in which PI will be elevated.
     * @return double value of PI elevation.
     */

    public static double piElevator (int power) {
        return Math.pow(PI, power);
    }
}
