import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutomobileDAOImpl implements AutomobileDAO{

    private static final List<CarBrands> VALUES = Collections.unmodifiableList(Arrays.asList(CarBrands.values()));
    private static final int SIZE = VALUES.size();
    private final Random random = new Random();

    @Override
    public Automobile createAutomobiles(List<Wheel> wheels, Engine engine) {
        Automobile automobile;
        automobile = new Automobile(wheels, engine, VALUES.get(random.nextInt(SIZE)).toString().toLowerCase());
        return automobile;
    }
}
