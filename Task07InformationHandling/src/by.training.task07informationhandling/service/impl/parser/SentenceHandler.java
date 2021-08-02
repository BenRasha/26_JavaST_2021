import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements ParseHandler {

    private ParseHandler handler;
    private static final String PATTERN_SENTENCE = "\\b[^.!?]+[.!?]+";

    @Override
    public void handle(String part, TextComponent component) {
        Pattern pattern = Pattern.compile(PATTERN_SENTENCE);
        Matcher matcher = pattern.matcher(part);
        while (matcher.find()) {
            String sentence = matcher.group();
            TextComponent child = new TextComposite(TextPartType.SENTENCE);
            component.addChild(child);
            if (handler != null) {
                handler.handle(sentence, child);
            }
        }
    }

    @Override
    public void setHandler(ParseHandler handler) {
        this.handler = handler;
    }
}