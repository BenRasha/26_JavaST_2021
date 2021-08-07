import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ParserTest {

    private static String text;
    private static TextFromFileReader textFromFileReader = new TextFromFileReader();
    private TextComponentParser textComponentParser = new TextComponentParser();

    @BeforeAll()
    public static void textSetUp() {
        try {
            text = textFromFileReader.getText(new File("text.txt"));
        } catch (ServiceException exception) {
            exception.printStackTrace();
        }
    }

    @Test()
    public void parserTest() {
        TextComponent component = textComponentParser.parseComponents(text);
        int expectedSize = 600;
        int actualSize = component.toString().length();
        Assertions.assertEquals(expectedSize, actualSize);
    }

}
