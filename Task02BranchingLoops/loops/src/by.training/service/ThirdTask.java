import java.util.ArrayList;
import java.util.List;

public class ThirdTask {

    private List<Double> result = new ArrayList<>();

    /**
     * Counts function with provided formula y = ctg(x/3) + 1/2sin(x).
     * @param number provided number to be used in formula as x.
     * @return list of results.
     */

    public List<Double> count(int number) {
        double answer = 1 / Math.tan(number/3) + 0.5 * Math.sin(number);
        result.add(answer);
        return result;
    }

}
