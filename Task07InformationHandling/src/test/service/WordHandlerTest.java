import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordHandlerTest {

    private String input = "established.";
    private ParseHandler wordHandler = new WordHandler();
    private TextComponent textComponent = new TextComposite(TextPartType.LEXEME);

    @Test
    public void handle() {
        wordHandler.handle(input, textComponent);
        int expectedAmount = 2;
        int actualAmount = textComponent.getChildren().size();
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

}
