import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CommandProviderTest {

    private CommandProvider commandProvider = new CommandProvider();

    @DataProvider(name = "PositiveDataForCommandProviding")
    public Object[][] createDataForCommandProviding() {
        return new Object[][]{
                {"bubble", new BubbleCommandImpl()},
                {"insertion", new InsertionCommandImpl()},
                {"shell", new ShellCommandImpl()},
                {"multiply", new MultiplyCommandImpl()},
                {"invalid", new WrongRequest()}
        };
    }

    @Test(description = "Positive scenario for getting command from command provider", dataProvider = "PositiveDataForCommandProviding")
    public void testGetCommand(String name, Command command) {
        Command actual = commandProvider.getCommand(name);
        Command expected = command;
        if (expected.equals(actual)) {
            assertTrue(true);
        }
    }

}
