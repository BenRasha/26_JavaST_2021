import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler implements ParseHandler {

    private ParseHandler handler;
    private static final String PUNCTUATION_BEFORE_WORD = "[({\\[]+";
    private static final String PUNCTUATION_AFTER_WORD = "[)},\\.\\]?!]+";
    private static final String WORD_IN_LEXEME = "(\\w+|-)";

    @Override
    public void handle(String part, TextComponent component) {
        Pattern beforePunctuation = Pattern.compile(PUNCTUATION_BEFORE_WORD);
        Pattern afterPunctuation = Pattern.compile(PUNCTUATION_AFTER_WORD);
        Pattern wordPattern = Pattern.compile(WORD_IN_LEXEME);
        Matcher matcher = beforePunctuation.matcher(part);
        if (matcher.find()) {
            addPunctuation(matcher, component);
        }
        String word = "";
        TextComponent wordComponent = null;
        matcher = wordPattern.matcher(part);
        if (matcher.find()) {
            word = matcher.group();
            wordComponent = new TextComposite(TextPartType.WORD);
            component.addChild(wordComponent);
        }
        matcher = afterPunctuation.matcher(part);
        if (matcher.find()) {
            addPunctuation(matcher, component);
        }
        if (handler != null && wordComponent != null) {
            handler.handle(word, wordComponent);
        }
    }

    @Override
    public void setHandler(ParseHandler handler) {
        this.handler = handler;
    }

    private void addPunctuation(Matcher matcher, TextComponent component) {
        String punctuation = matcher.group();
        for (int i = 0; i < punctuation.length(); i++) {
            Leaf child = new Leaf(TextPartType.SYMBOL);
            child.setSymbol(punctuation.charAt(i));
            component.addChild(child);
        }
    }

}