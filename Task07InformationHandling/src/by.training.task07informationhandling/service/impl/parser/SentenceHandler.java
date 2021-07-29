import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends BaseHandler {

    private static final String LEXEME_EXPRESSION = "\\s[^\\s]+[,.!?-]*";
    private static final String WORD_EXPRESSION = "[a-zA-Z]+";
    private static final String PATTERN_FORMULA = "(\\(?[\\d\\~\\&\\|\\^\\>\\<]+\\)*)+";

    @Override
    public TextComponent parse(String part) {
        TextComponent sentenceRoot = new TextComposite(TextPartType.SENTENCE);
        Pattern patternLexeme = Pattern.compile(LEXEME_EXPRESSION);
        Matcher matcherLexeme = patternLexeme.matcher(part);
        while (matcherLexeme.find()) {
            String lexeme = part.substring(matcherLexeme.start(), matcherLexeme.end());
            if (isFormula(lexeme)) {
                ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
                String notation = reversePolishNotation.getPolishNotation(lexeme);
                lexeme = String.valueOf(new Calculator(notation).calculate());
            }
            Pattern patternWord = Pattern.compile(WORD_EXPRESSION);
            Matcher matcherWord = patternWord.matcher(lexeme);
            if (matcherWord.find()) {
                if (next != null) {
                    sentenceRoot.addChild(next.parse(lexeme.substring(matcherWord.start(), matcherWord.end())));
                }
            }
            if (next != null) {
                sentenceRoot.addChild(next.parse(lexeme));
            }
        }
        return sentenceRoot;
    }

    private boolean isFormula(String lexeme) {
        Pattern patternFormula = Pattern.compile(PATTERN_FORMULA);
        Matcher matcherFormula = patternFormula.matcher(lexeme);
        return matcherFormula.find();
    }

}
