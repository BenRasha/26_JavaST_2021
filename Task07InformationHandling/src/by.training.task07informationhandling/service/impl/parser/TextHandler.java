import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler extends BaseHandler {

    private static final String PARAGRAPH_PATTERN = "(\\t|\\s{4}).+(\\n|$)";

    @Override
    public TextComponent parse(String part) {
        TextComponent textRoot = new TextComposite(TextPartType.TEXT);
        Pattern pattern = Pattern.compile(PARAGRAPH_PATTERN);
        Matcher matcher = pattern.matcher(part);
        while (matcher.find()) {
            if (next != null) {
                textRoot.addChild(next.parse(part.substring(matcher.start(), matcher.end())));
            }
        }
        return textRoot;
    }

}