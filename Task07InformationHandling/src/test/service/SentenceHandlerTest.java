import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SentenceHandlerTest {

    private String input = "\tTest. Second sentence!";
    private ParseHandler sentenceHandler = new SentenceHandler();
    private TextComponent textComponent = new TextComposite(TextPartType.PARAGRAPH);

    @Test
    public void handle() {
        sentenceHandler.handle(input, textComponent);
        int expectedAmount = 2;
        int actualAmount = textComponent.getChildren().size();
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

}
