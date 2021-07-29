import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends BaseHandler {

    private static final String SENTENCE_EXPRESSION = "[A-Z].*?[\\.\\?\\!]{1}";

    @Override
    public TextComponent parse(String part) {
        TextComponent paragraphRoot = new TextComposite(TextPartType.PARAGRAPH);
        Pattern pattern = Pattern.compile(SENTENCE_EXPRESSION);
        Matcher matcher = pattern.matcher(part);
        while (matcher.find()) {
            if (next != null) {
                paragraphRoot.addChild(next.parse(part.substring(matcher.start(), matcher.end())));
            }
        }
        return paragraphRoot;
    }

}
