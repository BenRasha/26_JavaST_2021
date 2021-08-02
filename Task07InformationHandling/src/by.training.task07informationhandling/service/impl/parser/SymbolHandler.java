import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolHandler implements ParseHandler {

    private static final String PATTERN_SYMBOL = ".";

    @Override
    public void handle(String part, TextComponent component) {
        Pattern letterPattern = Pattern.compile(PATTERN_SYMBOL);
        Matcher letterMatcher = letterPattern.matcher(part);
        while (letterMatcher.find()) {
            String letter = letterMatcher.group();
            Leaf child = new Leaf(TextPartType.SYMBOL);
            child.setSymbol(letter.charAt(0));
            component.addChild(child);
        }
    }

    @Override
    public void setHandler(ParseHandler handler) {

    }
}
