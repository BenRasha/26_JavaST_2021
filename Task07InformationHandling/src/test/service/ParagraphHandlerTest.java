import org.junit.jupiter.api.*;

public class ParagraphHandlerTest {

    private ParagraphHandler paragraphHandler;
    private TextComponent textComponent;

    @Test
    public void paragraphHandle() {
        String input = "\tHi.\n\tThis is new paragraph.";
        paragraphHandler = new ParagraphHandler();
        textComponent = new TextComposite(TextPartType.TEXT);
        paragraphHandler.handle(input, textComponent);
        int expectedAmountOfParagraphs = 2;
        int actualAmountOfParagraphs = textComponent.getChildren().size();
        Assertions.assertEquals(expectedAmountOfParagraphs, actualAmountOfParagraphs);
    }

}