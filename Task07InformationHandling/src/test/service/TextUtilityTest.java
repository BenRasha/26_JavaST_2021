import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TextUtilityTest {

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

    @Test
    public void sortParagraphTest() {
        TextComponent component = textComponentParser.parseComponents(text);
        String expected = component.getChildren().get(2).toString();
        TextUtility.sortParagraphs(component);
        String actual = component.getChildren().get(0).toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortLexemesTest() {
        TextComponent component = textComponentParser.parseComponents(text);
        TextUtility.sortLexemes(component);
        String actual = component.getChildren().get(1)
                .getChildren().get(0)
                .getChildren().get(0).toString();
        String expected = "a";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortWordsTest() {
        TextComponent component = textComponentParser.parseComponents(text);
        TextUtility.sortWords(component);
        String actual = component.getChildren().get(1)
                .getChildren().get(0)
                .getChildren().get(0).toString();
        String expected = "a";
        Assertions.assertEquals(expected, actual);
    }

}
