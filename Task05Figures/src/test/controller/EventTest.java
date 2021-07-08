import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class EventTest {

    private Registrator registrator = new Registrator();
    private List<Pyramid> pyramids;
    private Controller controller = new Controller();

    @BeforeTest
    public void createListeners() {
        registrator.events.subscribe("count_area", new AreaNotificationListener());
        registrator.events.subscribe("count_capacity", new CapacityNotificationListener());
        pyramids = PyramidStorage.getStorage().getAll();
    }


    @Test(description = "Positive scenario for updating area")
    public void updateArea() {
        for (Pyramid pyramid : PyramidStorage.getStorage().getAll()) {
            double actual = registrator.countArea(pyramid);
            double expected = controller.executeTask("count_area", pyramid);
            assertEquals(expected, actual);
        }
    }

    @Test(description = "Positive scenario for updating capacity")
    public void updateCapacity() {
        for (Pyramid pyramid : PyramidStorage.getStorage().getAll()) {
            double actual = registrator.countCapacity(pyramid);
            double expected = controller.executeTask("count_capacity", pyramid);
            assertEquals(expected, actual, 0.01);
        }
    }

}
