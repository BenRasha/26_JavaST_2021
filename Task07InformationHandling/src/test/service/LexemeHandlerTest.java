import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LexemeHandlerTest {

    private String input = "It is a 13>>2 established.";
    private ParseHandler lexemeHandler = new LexemeHandler();
    private TextComponent textComponent = new TextComposite(TextPartType.SENTENCE);

    @Test
    public void handle() {
        lexemeHandler.handle(input, textComponent);
        int expectedAmount = 5;
        int actualAmount = textComponent.getChildren().size();
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

}
