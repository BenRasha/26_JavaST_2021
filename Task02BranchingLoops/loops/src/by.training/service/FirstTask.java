import java.util.ArrayList;
import java.util.List;

public class FirstTask {

    private List<Integer> result = new ArrayList<>();

    /**
     * @param data provides all parameters for the cycle.
     * @return list with counted functions.
     */

    public List<Integer> functionCount(Data data) {
        for (int i = data.getLowerBorder(); i < data.getHigherBorder(); i += data.getStep()) {
            if (i <= 2) {
                result.add(-i);
            } else {
                result.add(i);
            }
        }
        return result;
    }
}
