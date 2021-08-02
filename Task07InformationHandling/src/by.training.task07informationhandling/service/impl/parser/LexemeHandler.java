import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements ParseHandler {

    private ParseHandler handler;
    private static final String PATTERN_LEXEME = "[^\\s]+";
    private static final String PATTERN_FORMULA = "(\\(?[\\d\\~\\&\\|\\^\\>\\<]+\\)*)+";

    @Override
    public void handle(String part, TextComponent component) {
        Pattern lexemePattern = Pattern.compile(PATTERN_LEXEME);
        Pattern formulaPattern = Pattern.compile(PATTERN_FORMULA);
        Matcher formulaMatcher = formulaPattern.matcher(part);
        while (formulaMatcher.find()) {
            String formula = formulaMatcher.group();
            ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
            Calculator calculator = new Calculator(reversePolishNotation.getPolishNotation(formula));
            int countedValue = calculator.calculate();
            part = part.replace(formula, String.valueOf(countedValue));
        }
        Matcher lexemeMatcher = lexemePattern.matcher(part);
        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();
            TextComponent child = new TextComposite(TextPartType.LEXEME);
            component.addChild(child);
            if (handler != null) {
                handler.handle(lexeme, child);
            }
        }
    }

    @Override
    public void setHandler(ParseHandler handler) {
        this.handler = handler;
    }
}