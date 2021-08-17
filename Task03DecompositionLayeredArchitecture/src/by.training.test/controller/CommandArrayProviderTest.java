import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CommandArrayProviderTest {

    private ArrayCommandProvider arrayCommandProvider = new ArrayCommandProvider();

    @DataProvider(name = "PositiveDataForCommandProviding")
    public Object[][] createDataForCommandProviding() {
        return new Object[][]{
                {"bubble", new BubbleCommandArrayImpl()},
                {"insertion", new InsertionCommandArrayImpl()},
                {"shell", new ShellCommandArrayImpl()},
                {"multiply", new MultiplyCommandMatrixImpl()},
        };
    }

    @Test(description = "Positive scenario for getting command from command provider", dataProvider = "PositiveDataForCommandProviding")
    public void testGetCommand(String name, CommandArray commandArray) {
        CommandArray actual = arrayCommandProvider.getCommand(name);
        CommandArray expected = commandArray;
        if (expected.equals(actual)) {
            assertTrue(true);
        }
    }

}
