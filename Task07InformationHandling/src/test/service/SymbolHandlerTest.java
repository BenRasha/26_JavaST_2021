import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SymbolHandlerTest {

    private String input = "Cat";
    private ParseHandler symbolHandler = new SymbolHandler();
    private TextComponent textComponent = new TextComposite(TextPartType.WORD);

    @Test
    public void handle() {
        symbolHandler.handle(input, textComponent);
        int expectedAmount = 3;
        int actualAmount = textComponent.getChildren().size();
        Assertions.assertEquals(expectedAmount, actualAmount);
    }
}
