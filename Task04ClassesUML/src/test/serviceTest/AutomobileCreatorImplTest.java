import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class AutomobileCreatorImplTest {

    private AutomobileCreatorImpl automobileCreator = new AutomobileCreatorImpl();

    @DataProvider(name = "PosititiveDataForDriveCheck")
    public Object[][] createDataForAutomobileCreation() {
        return new Object[][] {
                {new Wheel[]{new Wheel(0.1, 0.1, true), new Wheel(0.1,0.1, true), new Wheel(0.1,0.1,true), new Wheel(0.1, 0.1, true)}, new Engine("yo", 0.1, true), true},
                {new Wheel[]{new Wheel(0.1, 0.1, true), new Wheel(0.1,0.1, true), new Wheel(0.1,0.1,false), new Wheel(0.1, 0.1, true)}, new Engine("yo", 0.1, true), false},
                {new Wheel[]{new Wheel(0.1, 0.1, true), new Wheel(0.1,0.1, true), new Wheel(0.1,0.1,true), new Wheel(0.1, 0.1, true)}, new Engine("yo", 0.1, false), false}
        };
    }

    @DataProvider(name = "PositiveDataForEngineCharge")
    public Object[][] createDataForEngineCharge() {
        return new Object[][] {
                {new Wheel[]{new Wheel(0.1, 0.1, true), new Wheel(0.1,0.1, true), new Wheel(0.1,0.1,true), new Wheel(0.1, 0.1, true)}, new Engine("yo", 0.1, true), "yo"},
                {new Wheel[]{new Wheel(0.1, 0.1, true), new Wheel(0.1,0.1, true), new Wheel(0.1,0.1,true), new Wheel(0.1, 0.1, true)}, new Engine("yo", 0.1, false), "yo"}
        };
    }

    @Test(description = "Positive scenario for drive check", dataProvider = "PosititiveDataForDriveCheck")
    public void testEngineCheck(Wheel[] wheels, Engine engine, boolean c) {
        boolean actual = automobileCreator.drive(new Automobile(Arrays.asList(wheels), engine, "yo"));
        boolean expected = c;
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for engine charge check", dataProvider = "PositiveDataForEngineCharge")
    public void testEngineCharge(Wheel[] wheels, Engine engine, String brand) {
        Automobile actualAuto = new Automobile(Arrays.asList(wheels), engine, brand);
        Automobile expectedAuto = new Automobile(Arrays.asList(new Wheel(0.1, 0.1, true), new Wheel(0.1, 0.1, true), new Wheel(0.1, 0.1, true), new Wheel(0.1, 0.1, true)), new Engine("yo", 0.1, true), "yo");
        automobileCreator.chargeEngine(actualAuto);
        Engine actual = actualAuto.getEngine();
        Engine expected = expectedAuto.getEngine();
        assertEquals(actual, engine);
    }
}
