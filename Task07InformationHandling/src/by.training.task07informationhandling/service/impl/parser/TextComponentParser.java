public class TextComponentParser {

    private ParagraphHandler paragraphHandler = new ParagraphHandler();
    private SentenceHandler sentenceHandler = new SentenceHandler();
    private LexemeHandler lexemeHandler = new LexemeHandler();
    private WordHandler wordHandler = new WordHandler();
    private SymbolHandler symbolHandler = new SymbolHandler();

    public TextComponentParser() {
        paragraphHandler.setHandler(sentenceHandler);
        sentenceHandler.setHandler(lexemeHandler);
        lexemeHandler.setHandler(wordHandler);
        wordHandler.setHandler(symbolHandler);
    }

    public TextComponent parseComponents(String text) {
        TextComponent textComponent = new TextComposite(TextPartType.TEXT);
        paragraphHandler.handle(text, textComponent);
        return textComponent;
    }

}
