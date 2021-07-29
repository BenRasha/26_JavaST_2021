import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends BaseHandler {

    private static final String PATTERN_SYMBOL = "\\S";

    @Override
    public TextComponent parse(String part) {
        TextComponent wordRoot = new TextComposite(TextPartType.WORD);
        Pattern pattern = Pattern.compile(PATTERN_SYMBOL);
        Matcher matcher = pattern.matcher(part);
        while (matcher.find()) {
            Leaf leaf = new Leaf(part.substring(matcher.start(), matcher.end()));
            wordRoot.addChild(leaf);
        }
        return wordRoot;
    }

}
