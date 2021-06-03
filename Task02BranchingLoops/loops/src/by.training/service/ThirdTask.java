
public class ThirdTask {

    /**
     * Counts function with provided formula y = ctg(x/3) + 1/2sin(x).
     * @param number provided number to be used in formula as x.
     * @return double result.
     */

    public double count(int number) {
        return  1 / Math.tan(number/3) + 0.5 * Math.sin(number);
    }

}
