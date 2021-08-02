import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements ParseHandler {

    private ParseHandler handler;
    private static final String PARAGRAPH_PATTERN = "[^\\t]+";

    @Override
    public void handle(String part, TextComponent component) {
        Pattern pattern = Pattern.compile(PARAGRAPH_PATTERN);
        Matcher matcher = pattern.matcher(part);
        while (matcher.find()) {
            String paragraph = matcher.group();
            TextComponent paragraphRoot = new TextComposite(TextPartType.PARAGRAPH);
            component.addChild(paragraphRoot);
            if (handler != null) {
                handler.handle(paragraph, paragraphRoot);
            }
        }
    }

    @Override
    public void setHandler(ParseHandler handler) {
        this.handler = handler;
    }
}