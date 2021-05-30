import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {

    private static List<Integer> array = new ArrayList<>();

    /**
     * @return list of randomly generated numbers.
     */

    public  List<Integer> generate() {
        int i = 0;
        do {
            array.add(-1 + (int)(Math.random() * 15));
            i++;
        } while (i<5);
        return array;
    }
}
